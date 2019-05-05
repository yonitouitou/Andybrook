package com.andybrook.model.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.api.pdf.CloseOrderPdfBuilder;
import com.andybrook.api.pdf.IPdfBuilder;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.api.Email;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.setting.AdminSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Path;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OrderClosedEmailNotification implements IEmailNotification<AggregatedOrder> {

    private static final Logger LOGGER = System.getLogger(OrderClosedEmailNotification.class.getSimpleName());
    private static final DateTimeFormatter DATE_TIME_FORMATTER_FILE_NAME = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Email createEmail(AdminSetting adminSetting, AggregatedOrder order) {
        return Email.builder()
                .fromAdress(applicationProperties.getNotificationEmailFrom())
                .toAdresses(adminSetting.getEmails())
                .withSubject("Order " + order.getName() + " (" + order.getId() + ") closed")
                .withBody(getBody(order))
                .withAttachmentFile(getAttachmentsPaths(order))
                .build();

    }

    private Path[] getAttachmentsPaths(AggregatedOrder order) {
        Path csvPath = generateCsvFile(order);
        Path pdfPath = generatePdfFile(order);
        return new Path[] {csvPath, pdfPath};
    }

    private Path generatePdfFile(AggregatedOrder order) {
        IPdfBuilder<AggregatedOrder> builder = applicationContext.getBean(CloseOrderPdfBuilder.class);
        return builder.generatePdf(order);
    }

    private Path generateCsvFile(AggregatedOrder order) {
        Path csvFilePath = null;
        try {
            String content = generateCsvFileContent(order);
            csvFilePath = writeCsvInFile(order, content);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Exception occurred generating the attachment CSV file for report : ["
                    + order.getId() + ", " + order.getName() + "]");
        }
        return csvFilePath;
    }

    private String generateCsvFileContent(AggregatedOrder order) {
        StringBuilder sb = new StringBuilder();
        appendColumnsName(sb);
        sb.append(System.lineSeparator());
        appendOrderItemsRows(sb, order.getAggregatedOrderItems());
        return sb.toString();
    }

    private Path writeCsvInFile(AggregatedOrder order, String csv) throws IOException {
        System.out.println(csv);
        String fileName = order.getName() + "-" + order.getCreatedDatetime().format(DATE_TIME_FORMATTER_FILE_NAME);
        File tmpFile = File.createTempFile(fileName, ".csv");
        FileWriter writer = new FileWriter(tmpFile);
        try {
            writer.write(csv);
            writer.flush();
        } finally {
            writer.close();
        }
        return tmpFile.toPath();
    }

    private void appendColumnsName(StringBuilder sb) {
        sb.append("Name").append(",")
            .append("Quantity").append(",")
            .append("Price");
    }

    private void appendOrderItemsRows(StringBuilder sb, List<AggregatedOrderItem> items) {
        items.forEach(aggregatedOrderItem -> {
            generateOrderItemCsvRow(sb, aggregatedOrderItem);
        });
    }

    private void generateOrderItemCsvRow(StringBuilder sb, AggregatedOrderItem aggregatedOrderItem) {
        Product product = aggregatedOrderItem.getProduct();
        sb.append(product.getName()).append(",")
                .append(aggregatedOrderItem.getQuantity()).append(",")
                .append(product.getPrice())
                .append(System.lineSeparator());
    }

    private String getBody(AggregatedOrder order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Order " + order.getName() + " (" + order.getId() + ") has been closed on " + getFormattedDateTime(ZonedDateTime.now(ZoneId.of("Europe/Paris"))));
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
