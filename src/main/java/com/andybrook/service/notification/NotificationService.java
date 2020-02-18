 package com.andybrook.service.notification;

 import com.andybrook.model.notification.Notification;
 import com.andybrook.model.notification.handler.document.IDocumentGenerator;
 import com.andybrook.model.notification.handler.protocol.INotificationProtocolHandler;
 import com.andybrook.model.notification.request.NotificationRequest;
 import com.andybrook.model.notification.request.ctx.DocumentRequest;
 import com.andybrook.service.notification.documentgenerator.IDocumentGeneratorService;
 import com.andybrook.service.notification.protocol.INotificationProtocolHandlerService;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.ApplicationContext;
 import org.springframework.stereotype.Service;

 import java.nio.file.Path;
 import java.util.List;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private IDocumentGeneratorService documentHandlerService;
    @Autowired
    private INotificationProtocolHandlerService notificationProtocolHandlerService;

    @Override
    public Notification notify(NotificationRequest request) {
        DocumentRequest documentRequest = request.getDocumentRequest();
        List<Path> documents = generateDocuments(documentRequest);
        return doNotification(request, documents);
    }

    private List<Path> generateDocuments(DocumentRequest documentRequest) {
        Class<IDocumentGenerator> handlerClass = documentHandlerService.getDocumentGenerator(documentRequest.getType());
        IDocumentGenerator handler = applicationContext.getBean(handlerClass);
        return handler.generate(documentRequest);
    }

    private Notification doNotification(NotificationRequest request, List<Path> documents) {
        INotificationProtocolHandler handler = notificationProtocolHandlerService.getHandler(request.getType());
        return handler.handle(request, documents);
    }
}
