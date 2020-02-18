package com.andybrook.model.notification.handler.protocol;

import com.andybrook.model.notification.Notification;
import com.andybrook.model.notification.request.NotificationRequest;

import java.nio.file.Path;
import java.util.List;

public interface INotificationProtocolHandler {

    Notification handle(NotificationRequest request, List<Path> files);

}
