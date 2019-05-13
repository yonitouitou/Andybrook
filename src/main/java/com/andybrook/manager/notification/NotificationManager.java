package com.andybrook.manager.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import com.andybrook.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Arrays;

@Service
public class NotificationManager implements INotificationManager {

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private INotificationService notificationService;
    @Autowired
    private IAdminSettingManager adminSettingManager;

    @Override
    public void notify(NotificationRequest request) throws OrderNotFound {
        if (adminSettingManager.shouldNotifyOnCloseOrder()) {
            notificationService.notify(request);
        }
    }
}
