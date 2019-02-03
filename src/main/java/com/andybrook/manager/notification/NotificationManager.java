package com.andybrook.manager.notification;

import com.andybrook.model.StockReport;
import com.andybrook.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager implements INotificationManager {

    @Autowired
    private INotificationService notificationService;

    @Override
    public void notifyReportClosed(StockReport report) {
        notificationService.notifyReportClosed(report);
    }
}
