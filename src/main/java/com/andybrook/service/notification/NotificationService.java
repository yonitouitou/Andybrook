 package com.andybrook.service.notification;

import com.andybrook.api.email.EmailSender;
import com.andybrook.enums.FileFormat;
import com.andybrook.enums.NotificationType;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.api.Email;
import com.andybrook.model.notification.handler.IDocumentHandler;
import com.andybrook.model.notification.request.DocumentRequest;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.DocumentCtx;
import com.andybrook.model.notification.request.setting.EmailSetting;
import com.andybrook.model.notification.request.setting.NotifSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NotificationService implements INotificationService {

    private static final Logger LOGGER = System.getLogger(NotificationService.class.getSimpleName());

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private IDocumentHandlerService documentHandlerService;

    @Override
    public List<Path> notify(NotificationRequest request) throws OrderNotFound {
        List<Path> paths = new ArrayList<>(request.getNotificationTypes().size());
        for (NotificationType type : request.getNotificationTypes()) {
            DocumentRequest documentRequest = request.getDocumentRequest();
            Class<IDocumentHandler> handlerClass = documentHandlerService.getHandler(documentRequest.getType());
            IDocumentHandler handler = applicationContext.getBean(handlerClass);
            for (FileFormat format : documentRequest.getFormats()) {
                try {
                    Path path = handler.generateDocument(format, documentRequest.getCtx());
                    paths.add(path);
                } catch (Exception e) {
                    LOGGER.log(Level.ERROR, "Error occurred when try to generate "
                            + format + " document : " + request.toString(), e);
                }
            }
            if (type.isAsync()) {
                EmailSetting setting = (EmailSetting) request.getSetting(type);
                if (setting != null && setting.hasEmails()) {
                    sendEmail(setting, handler, documentRequest.getCtx(), paths);
                }
            }
        }
        return paths;
    }

    private void sendEmail(EmailSetting setting, IDocumentHandler handler, DocumentCtx documentCtx, List<Path> attachments) {
        try {
            Email email = handler.generateEmail(setting, documentCtx, attachments);
            emailSender.send(email);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Email not sent to " + Arrays.toString(setting.getEmails()), e);
        }
    }
}
