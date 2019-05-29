package com.andybrook.model.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.api.Email;
import com.andybrook.model.notification.request.ctx.NotifSetting;
import com.andybrook.model.product.Product;
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
    public Email createEmail(NotifSetting setting, AggregatedOrder order, List<Path> attachments) {
        return Email.builder()
                .fromAdress(applicationProperties.getNotificationEmailFrom())
                .toAdresses(setting.getEmails())
                .withSubject(getSubject(setting, order))
                .withBody(getBody(setting, order))
                .withAttachmentFile(attachments)
                .build();
    }

    private String getSubject(NotifSetting setting, AggregatedOrder order) {
        String prefix = setting.isLiveEvent() ? "[Live]" : "[Notification]";
        return prefix + " Order " + order.getName() + " (" + order.getId() + ") closed";
    }

    private String getBody(NotifSetting setting, AggregatedOrder order) {
        StringBuilder sb = new StringBuilder();
        sb.append(getHeaderOfBody(setting, order));
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

    private String getHeaderOfBody(NotifSetting setting, AggregatedOrder order) {
        StringBuilder sb = new StringBuilder();
        if (setting.isLiveEvent()) {
            sb.append("Order ").append(order.getName()).append(" (" ).append(order.getId()).append(") of store ")
                    .append(order.getCustomer().getStore().getName()).append(" has been closed on ")
                    .append(getFormattedDateTime(ZonedDateTime.now(applicationProperties.getZoneId())));
        } else {
            sb.append("Notification sent for order ").append(order.getName()).append(" (" ).append(order.getId()).append(") of store ")
                    .append(order.getCustomer().getStore().getName()).append(" closed on ")
                    .append(getFormattedDateTime(ZonedDateTime.of(order.getCloseDatetime(), applicationProperties.getZoneId())));
        }
        return sb.toString();
    }

    private static String getFormattedDateTime(ZonedDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.RFC_1123_DATE_TIME);
    }


}
