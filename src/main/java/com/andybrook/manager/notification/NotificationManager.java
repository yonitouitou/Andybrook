package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.setting.IAdminSettingManager;
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
    @Autowired
    private IAdminSettingManager adminSettingManager;

    @Override
    public void notify(NotificationRequest request) throws OrderNotFound {
        if (adminSettingManager.shouldNotifyOnCloseOrder()) {
            notificationService.asyncNotify(request);
        }
    }

    @Override
    public List<Path> generateDocuments(NotificationRequest request) {
        return notificationService.syncNotify(request);
    }
}
