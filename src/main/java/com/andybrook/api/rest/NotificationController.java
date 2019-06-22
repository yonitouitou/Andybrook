package com.andybrook.api.rest;

import com.andybrook.ApplicationProperties;
import com.andybrook.api.rest.ctx.notification.OrderDocumentRestRequest;
import com.andybrook.api.rest.ctx.notification.RestDocType;
import com.andybrook.enums.DocType;
import com.andybrook.enums.NotificationType;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.model.notification.request.DocumentRequest;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.notification.request.setting.EmailSetting;
import com.andybrook.model.order.Order;
import com.andybrook.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;

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

    @PostMapping(path = "/notify")
    public ResponseEntity<Resource> downloadFile(@RequestBody OrderDocumentRestRequest request) throws IOException {
        Order order = orderManager.getOrder(request.getOrderId());
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(false, order)
                .setDateDocument(epochTimeInMillisToZdt(request.getDateDocument(), applicationProperties.getZoneId()))
                .build();
        DocumentRequest documentRequest = new DocumentRequest(request.getDocType(), ctx, request.getFileFormats());
        NotificationRequest req = new NotificationRequest(false, documentRequest);
        if (request.getEmails().length > 0) {
            req.addNotificationType(NotificationType.EMAIL, new EmailSetting(request.getEmails()));
        }
        req.addNotificationType(NotificationType.DOWNLOAD, null);
        Path path = notificationManager.notify(req).get(0);
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

    @GetMapping(path = "/document-types")
    public RestDocType[] getDocumentTypes() {
        DocType[] types = DocType.values();
        RestDocType[] notifs = new RestDocType[types.length];
        for (int i = 0; i < types.length; i++) {
            notifs[i] = RestDocType.fromDocType(types[i]);
        }
        return notifs;
    }

    @GetMapping(path = "/notification-types")
    public NotificationType[] getNotificationTypes() {
        return NotificationType.values();
    }
}
