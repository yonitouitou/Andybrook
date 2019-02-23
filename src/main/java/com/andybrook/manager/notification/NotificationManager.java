package com.andybrook.manager.notification;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.StockReport;
import com.andybrook.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager implements INotificationManager {

    @Autowired
    private INotificationService notificationService;
    @Autowired
    private IAdminSettingManager adminSettingManager;

    @Override
    public void notifyOrder(long orderId) throws OrderNotFound {
        notificationService.notifyOrder(orderId);
    }

    @Override
    public void notifyOrderClosed(StockReport report) {
        if (adminSettingManager.shouldNotifyOnCloseReport()) {
            notificationService.notifyOrderClosed(report);
        }
    }
}
