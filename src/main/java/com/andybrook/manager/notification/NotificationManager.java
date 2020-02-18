package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.notification.Notification;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.service.notification.INotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager implements INotificationManager {

    @Autowired
    private INotificationService notificationService;

    @Override
    public Notification notify(NotificationRequest request) throws OrderNotFound {
        return notificationService.notify(request);
    }
}
