package com.andybrook.api.rest;

import com.andybrook.ApplicationProperties;
import com.andybrook.api.rest.ctx.notification.OrderDocumentRestRequest;
import com.andybrook.api.rest.ctx.notification.RestDocType;
import com.andybrook.enums.DocType;
import com.andybrook.enums.NotificationType;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.DownloadNotification;
import com.andybrook.model.notification.request.DownloadNotificationRequest;
import com.andybrook.model.notification.request.EmailNotificationRequest;
import com.andybrook.model.notification.request.ctx.DocumentRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import com.andybrook.util.file.FileUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

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
        AggregatedOrder aggregatedOrder = orderManager.aggregate(request.getOrderId());
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(false, order, aggregatedOrder)
                .setDateDocument(epochTimeInMillisToZdt(request.getDateDocument(), applicationProperties.getZoneId()))
                .build();

        DocumentRequest documentRequest = new DocumentRequest(request.getDocType(), ctx, Arrays.asList(request.getFileFormats()));
        if (request.getEmails().length > 0) {
            sendEmailNotification(request, documentRequest);
        }
        DownloadNotification downloadNotification = sendDownloadNotification(documentRequest);
        Path fileToDownload = downloadNotification.getDownloadedFiles().get(0);

        Resource resource = new FileUrlResource(fileToDownload.toString());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(extractContentType(fileToDownload)))
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

    private void sendEmailNotification(OrderDocumentRestRequest req, DocumentRequest documentRequest) {
        EmailNotificationRequest emailReq = new EmailNotificationRequest(false, documentRequest);
        for (String address : req.getEmails()) {
            emailReq.addAddress(address);
        }
        notificationManager.notify(emailReq);
    }

    private DownloadNotification sendDownloadNotification(DocumentRequest documentRequest) {
        DownloadNotificationRequest downloadRequest = new DownloadNotificationRequest(false, documentRequest);
        return (DownloadNotification) notificationManager.notify(downloadRequest);
    }

    private static String extractContentType(Path path) {
        String contentType = null;
        try {
            contentType = Files.probeContentType(path);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Exception occured when try to extract content type of file : " + path.toAbsolutePath().toString());
        }
        return contentType != null ? contentType : "application/octet-stream";
    }
}
