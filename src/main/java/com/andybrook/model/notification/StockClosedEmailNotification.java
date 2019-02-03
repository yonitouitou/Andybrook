package com.andybrook.model.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.model.StockReport;
import com.andybrook.model.api.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StockClosedEmailNotification implements IEmailNotification<StockReport> {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public Email createEmail(StockReport report) {
        return Email.builder()
                .fromAdress(applicationProperties.getNotificationEmailFrom())
                .toAdresses(applicationProperties.getNotificationEmailTo())
                .withSubject("Report " + report.getId() + " closed")
                .withBody("Bodyyyyyyyyyyyyyyyyy")
                .build();

    }
}
