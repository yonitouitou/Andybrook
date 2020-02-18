package com.andybrook.model.notification.handler.protocol.email;

import com.andybrook.annotation.NotificationProtocolHandler;
import com.andybrook.api.email.EmailSender;
import com.andybrook.enums.DocType;
import com.andybrook.enums.NotificationType;
import com.andybrook.model.api.Email;
import com.andybrook.model.notification.EmailNotification;
import com.andybrook.model.notification.handler.protocol.INotificationProtocolHandler;
import com.andybrook.model.notification.request.EmailNotificationRequest;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.service.notification.protocol.email.IEmailCreatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;

@Component
@NotificationProtocolHandler(NotificationType.EMAIL)
public class EmailProtocolHandler implements INotificationProtocolHandler {

    @Autowired
    private IEmailCreatorService emailCreatorService;
    @Autowired
    private EmailSender emailSender;

    public EmailNotification handle(NotificationRequest request, List<Path> files) {
        EmailNotificationRequest emailRequest = (EmailNotificationRequest) request;
        DocType docType = request.getDocumentRequest().getType();
        IEmailCreator creator = emailCreatorService.getEmailCreator(docType);
        Email email = creator.createEmail(emailRequest, files);
        boolean isSent = emailSender.send(email);
        return new EmailNotification(email, isSent);
    }
}
