package com.andybrook.manager.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.notification.ctx.DocSetting;
import com.andybrook.model.notification.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import com.andybrook.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class NotificationManager implements INotificationManager {

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private INotificationService notificationService;
    @Autowired
    private IAdminSettingManager adminSettingManager;

    @Override
    public void notifyOrder(OrderDocumentCtx ctx) throws OrderNotFound {
        notificationService.notifyOrder(ctx);
    }

    @Override
    public void notifyOrderClosed(Order order) {
        if (adminSettingManager.shouldNotifyOnCloseOrder()) {
            DocSetting setting = new DocSetting(true, ZonedDateTime.now(applicationProperties.getZoneId()));
            notificationService.notifyOrderClosed(order, setting);
        }
    }
}
