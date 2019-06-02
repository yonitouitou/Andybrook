package com.andybrook.api.rest;

import com.andybrook.ApplicationProperties;
import com.andybrook.api.rest.ctx.notification.OrderDocumentRestRequest;
import com.andybrook.enums.NotificationType;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import com.andybrook.util.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import static com.andybrook.util.DateUtil.epochTimeInMillisToZdt;

@RestController
@RequestMapping("v1/notification")
public class NotificationController extends AbstractController {

    private static Logger LOGGER = System.getLogger(OrderController.class.getSimpleName());

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private INotificationManager notificationManager;
    @Autowired
    private IOrderManager orderManager;

    @PostMapping(path = "/async-order-notification")
    public void notify(@RequestBody OrderDocumentRestRequest request) throws OrderNotFound {
        LOGGER.log(Level.INFO, "Notifications request : " + request.toString());
        Order order = orderManager.getOrder(request.getOrderId());
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(false, order)
                .setDateDocument(epochTimeInMillisToZdt(request.getDateDocument(), applicationProperties.getZoneId()))
                .setEmails(request.getEmails())
                .build();
        notificationManager.notify(new NotificationRequest(request.getTypes(), ctx));
    }

    @PostMapping(path = "/sync-order-notification")
    public ResponseEntity<Resource> downloadFile(@RequestBody OrderDocumentRestRequest request) throws IOException {
        Order order = orderManager.getOrder(request.getOrderId());
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(false, order)
                .setDateDocument(epochTimeInMillisToZdt(request.getDateDocument(), applicationProperties.getZoneId()))
                .setEmails(request.getEmails())
                .build();
        Path path = notificationManager.generateDocuments(new NotificationRequest(request.getTypes(), ctx)).get(0);
        String contentType = Files.probeContentType(path);
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        Resource resource = new FileUrlResource(path.toFile().getAbsolutePath());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .header("filename", order.getName() + "." + FileUtil.getExtension(resource.getFilename()))
                .body(resource);
    }

    @GetMapping(path = "/notification-types")
    public NotificationType[] getNotificationTypes() {
        return NotificationType.values();
    }
}
