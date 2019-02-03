package com.andybrook.service.notification;

import com.andybrook.api.email.EmailSender;
import com.andybrook.model.StockReport;
import com.andybrook.model.notification.IEmailNotification;
import com.andybrook.model.notification.StockClosedEmailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private EmailSender emailSender;

    @Override
    public void notifyReportClosed(StockReport report) {
        IEmailNotification<StockReport> closedReportNotif = applicationContext.getBean(StockClosedEmailNotification.class);
        emailSender.send(closedReportNotif.createEmail(report));
    }
}
