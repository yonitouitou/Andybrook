package com.andybrook.model.notification.handler.protocol.email;

import com.andybrook.model.api.Email;
import com.andybrook.model.notification.request.EmailNotificationRequest;

import java.nio.file.Path;
import java.util.List;

public interface IEmailCreator {

    Email createEmail(EmailNotificationRequest notification, List<Path> attachments);
}
