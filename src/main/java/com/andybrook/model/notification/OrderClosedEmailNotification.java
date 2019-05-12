package com.andybrook.model.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.api.Email;
import com.andybrook.model.product.Product;
import com.andybrook.model.setting.AdminSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OrderClosedEmailNotification implements IEmailNotification<AggregatedOrder> {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public Email createEmail(AdminSetting adminSetting, AggregatedOrder order, List<Path> attachments) {
        return Email.builder()
                .fromAdress(applicationProperties.getNotificationEmailFrom())
                .toAdresses(adminSetting.getEmails())
                .withSubject("Order " + order.getName() + " (" + order.getId() + ") closed")
                .withBody(getBody(order))
                .withAttachmentFile(attachments)
                .build();

    }

    private String getBody(AggregatedOrder order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Order " + order.getName() + " (" + order.getId() + ") of store " + order.getCustomer().getStore().getName() +
                " has been closed on " + getFormattedDateTime(ZonedDateTime.now(applicationProperties.getZoneId())));
        sb.append("</br></br>");

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
                        + "<td>" + order.getId() + "</td>"
                        + "<td>" + order.getName() + "</td>"
                        + "<td>" + order.getAggregatedOrderInfo().getOrderItemSize() + "</td>"
                        + "<td>" + order.getAggregatedOrderInfo().getTotalPrice() + " €</td>"
                + "</tr>"
        );

        sb.append("</table>");
        sb.append("</br></br>");
        sb.append(
                "<table width='100%' border='1' align='center'>"
                        + "<tr align='center'>"
                        + "<td><b>Name<b></td>"
                        + "<td><b>Unit Price<b></td>"
                        + "<td><b>Quantity<b></td>"
                        + "<td><b>Price<b></td>"
                        + "</tr>"
        );

        for (int i = 0; i < order.getAggregatedOrderItems().size(); i++) {
            AggregatedOrderItem aggregatedOrderItem = order.getAggregatedOrderItems().get(i);
            Product product = aggregatedOrderItem.getProduct();
            sb.append(
                    "<tr align='center'>"
                            + "<td>" + product.getName() + "</td>"
                            + "<td>" + product.getPrice() + "€ </td>"
                            + "<td>" + aggregatedOrderItem.getQuantity() + "</td>"
                            + "<td>" + aggregatedOrderItem.getTtlPrice() + "€ </td>"
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
