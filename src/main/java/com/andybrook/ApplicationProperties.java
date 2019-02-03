package com.andybrook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {

    @Value("${notification.email.to}")
    private String[] notificationEmailTo;

    @Value("${notification.email.from}")
    private String notificationEmailFrom;

    public String[] getNotificationEmailTo() {
        return notificationEmailTo;
    }

    public String getNotificationEmailFrom() {
        return notificationEmailFrom;
    }
}
