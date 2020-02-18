package com.andybrook.model.notification.handler.protocol.email;

import com.andybrook.ApplicationProperties;
import com.andybrook.annotation.EmailOf;
import com.andybrook.enums.DocType;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.api.Email;
import com.andybrook.model.notification.request.EmailNotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.product.Product;
import com.andybrook.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@EmailOf(DocType.ORDER_FORM)
public class OrderEmailCreator implements IEmailCreator {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public Email createEmail(EmailNotificationRequest notification, List<Path> attachments) {
        return Email.builder()
                .toAddresses(notification.getAddresses())
                .withSubject(createSubject(notification))
                .withAttachmentFile(attachments)
                .withBody(getBody(notification))
                .build();
    }

    private String createSubject(EmailNotificationRequest req) {
        OrderDocumentCtx ctx = (OrderDocumentCtx) req.getDocumentRequest().getCtx();
        return (req.isLiveEvent() ? "New" : "") + "Order " + ctx.getOrder().getId();
    }

    private String getBody(EmailNotificationRequest notification) {
        OrderDocumentCtx ctx = (OrderDocumentCtx) notification.getDocumentRequest().getCtx();
        AggregatedOrder order = ctx.getAggregatedOrder();
        StringBuilder sb = new StringBuilder();
        sb.append(getHeaderOfBody(notification, order));
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

    private String getHeaderOfBody(EmailNotificationRequest req, AggregatedOrder order) {
        StringBuilder sb = new StringBuilder();
        if (req.isLiveEvent()) {
            sb.append("Order ").append(order.getName()).append(" (" ).append(order.getId()).append(") of store ")
                    .append(order.getStore().getName()).append(" has been closed on ")
                    .append(getFormattedDateTime(ZonedDateTime.now(applicationProperties.getZoneId())));
        } else {
            sb.append("Notification sent for order ").append(order.getName()).append(" (" ).append(order.getId()).append(") of store ")
                    .append(order.getStore().getName()).append(" closed on ")
                    .append(getFormattedDateTime(DateUtil.epochTimeInMillisToZdt(order.getCloseDatetime(), applicationProperties.getZoneId())));
        }
        return sb.toString();
    }

    private static String getFormattedDateTime(ZonedDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.RFC_1123_DATE_TIME);
    }

}
