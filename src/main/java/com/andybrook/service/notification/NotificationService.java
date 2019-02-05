package com.andybrook.service.notification;

import com.andybrook.api.email.EmailSender;
import com.andybrook.model.StockReport;
import com.andybrook.model.notification.IEmailNotification;
import com.andybrook.model.notification.StockClosedEmailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private EmailSender emailSender;

    private static final ExecutorService MAIL_SENDER_EXECUTOR = Executors.newSingleThreadExecutor();

    @Override
    public void notifyReportClosed(StockReport report) {
        MAIL_SENDER_EXECUTOR.submit(new MailSenderThread(report));
    }

    private class MailSenderThread implements Callable<Boolean> {

        private final StockReport report;

        public MailSenderThread(StockReport report) {
            this.report = report;
        }

        @Override
        public Boolean call() {
            IEmailNotification<StockReport> closedReportNotif = applicationContext.getBean(StockClosedEmailNotification.class);
            return emailSender.send(closedReportNotif.createEmail(report));
        }
    }


}
