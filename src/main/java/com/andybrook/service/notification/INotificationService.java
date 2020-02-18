package com.andybrook.service.notification;

import com.andybrook.model.notification.Notification;
import com.andybrook.model.notification.request.NotificationRequest;

public interface INotificationService {

    Notification notify(NotificationRequest request);
}
