package com.andybrook.service.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.notification.request.NotificationRequest;

import java.nio.file.Path;
import java.util.List;

public interface INotificationService {

    void asyncNotify(NotificationRequest request) throws OrderNotFound;

    List<Path> syncNotify(NotificationRequest request);
}
