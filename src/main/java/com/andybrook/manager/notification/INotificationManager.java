package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.notification.Notification;
import com.andybrook.model.notification.request.NotificationRequest;

public interface INotificationManager {

    Notification notify(NotificationRequest request) throws OrderNotFound;
}
