package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.notification.request.DocumentRequest;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class NotificationManager implements INotificationManager {

    @Autowired
    private INotificationService notificationService;


    @Override
    public List<Path> notify(NotificationRequest request) throws OrderNotFound {
        return notificationService.notify(request);
    }
}
