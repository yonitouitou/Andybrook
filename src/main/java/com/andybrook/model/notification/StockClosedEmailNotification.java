package com.andybrook.model.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.api.Email;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
                .withBody(getBody(report))
                .build();

    }

    private String getBody(StockReport report) {
        StringBuilder sb = new StringBuilder();
        sb.append("Report " + report.getId() + " has been closed on " + getFormattedDateTime(ZonedDateTime.now(ZoneId.of("Europe/Paris"))));
        sb.append("</br>");

        sb.append(
                "<table width='100%' border='1' align='center'>"
                        + "<tr align='center'>"
                        + "<td><b>ID<b></td>"
                        + "<td><b>Name<b></td>"
                        + "<td><b>Quantity<b></td>"
                        + "<td><b>Price<b></td>"
                        + "</tr>"
        );

        sb.append(
                "<tr align='center'>"
                        + "<td>" + report.getId() + "</td>"
                        + "<td>" + report.getName() + "</td>"
                        + "<td>" + report.getTotalQuantity() + "</td>"
                        + "<td>" + report.getTotalPrice() + " €</td>"
                + "</tr>"
        );

        sb.append("</table>");

        sb.append(
                "<table width='100%' border='1' align='center'>"
                        + "<tr align='center'>"
                        + "<td><b>ID<b></td>"
                        + "<td><b>Name<b></td>"
                        + "<td><b>Quantity<b></td>"
                        + "<td><b>Price<b></td>"
                        + "</tr>"
        );

        for (StockItem<? extends Product> item: report.getItems()) {
            sb.append(
                    "<tr align='center'>"
                            + "<td>" + item.getId() + "</td>"
                            + "<td>" + item.getProduct().getName() + "</td>"
                            + "<td>" + item.getQuantity() + "</td>"
                            + "<td>" + item.getProduct().getPrice() + "</td>"
                    + "</tr>"
            );
        }
        sb.append("</table>");
        sb.append("</br>");
        return sb.toString();
    }

    private static String getFormattedDateTime(ZonedDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.RFC_1123_DATE_TIME);
    }


}
