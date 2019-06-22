package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.notification.request.NotificationRequest;

import java.nio.file.Path;
import java.util.List;

public interface INotificationManager {

    List<Path> notify(NotificationRequest request) throws OrderNotFound;
}
