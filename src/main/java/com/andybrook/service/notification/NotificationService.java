package com.andybrook.service.notification;

import com.andybrook.model.StockReport;
import com.andybrook.model.notification.event.ctx.CloseReportEvent;
import com.andybrook.service.setting.IAdminSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void notifyReportClosed(StockReport report) {
        publisher.publishEvent(new CloseReportEvent(report));
    }
}
