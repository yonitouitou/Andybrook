package com.andybrook.model.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.api.pdf.CloseReportPdfBuilder;
import com.andybrook.api.pdf.IPdfBuilder;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.api.Email;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.setting.AdminSetting;
import com.andybrook.util.OrderItemAggregatorUtil;
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
public class OrderClosedEmailNotification implements IEmailNotification<Order> {

    private static final Logger LOGGER = System.getLogger(OrderClosedEmailNotification.class.getSimpleName());
    private static final DateTimeFormatter DATE_TIME_FORMATTER_FILE_NAME = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Email createEmail(AdminSetting adminSetting, Order report) {
        return Email.builder()
                .fromAdress(applicationProperties.getNotificationEmailFrom())
                .toAdresses(adminSetting.getEmails())
                .withSubject("Report " + report.getId() + " closed")
                .withBody(getBody(report))
                .withAttachmentFile(getAttachmentsPaths(report))
                .build();

    }

    private Path[] getAttachmentsPaths(Order order) {
        Path csvPath = generateCsvFile(order);
        Path pdfPath = generatePdfFile(order);
        return new Path[] {csvPath, pdfPath};
    }

    private Path generatePdfFile(Order report) {
        IPdfBuilder<Order> builder = applicationContext.getBean(CloseReportPdfBuilder.class);
        return builder.generatePdf(report);
    }

    private Path generateCsvFile(Order order) {
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

    private String generateCsvFileContent(Order order) {
        StringBuilder sb = new StringBuilder();
        appendColumnsName(sb);
        sb.append(System.lineSeparator());
        appendOrderItemsRows(sb, OrderItemAggregatorUtil.getAggregatedOrderItems(order));
        return sb.toString();
    }

    private Path writeCsvInFile(Order report, String csv) throws IOException {
        System.out.println(csv);
        String fileName = report.getName() + "-" + report.getCreatedDateTime().format(DATE_TIME_FORMATTER_FILE_NAME);
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
        sb.append("Id").append(",")
            .append("Name").append(",")
            .append("quantityCreated").append(",")
            .append("Price");
    }

    private void appendOrderItemsRows(StringBuilder sb, List<AggregatedOrderItem> items) {
        items.forEach(aggregatedOrderItem -> {
            generateOrderItemCsvRow(sb, aggregatedOrderItem);
        });
    }

    private void generateOrderItemCsvRow(StringBuilder sb, AggregatedOrderItem aggregatedOrderItem) {
        OrderItem orderItem = aggregatedOrderItem.getOrderItems().get(0);
        sb.append(orderItem.getProductItem().getName()).append(",")
                .append(aggregatedOrderItem.getQuantity()).append(",")
                .append(orderItem.getProductItem().getPrice())
                .append(System.lineSeparator());
    }

    private String getBody(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Report " + order.getId() + " has been closed on " + getFormattedDateTime(ZonedDateTime.now(ZoneId.of("Europe/Paris"))));
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
                        + "<td>" + order.getTotalQuantity() + "</td>"
                        + "<td>" + order.calculateTotalPrice() + " €</td>"
                + "</tr>"
        );

        sb.append("</table>");
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

        for (AggregatedOrderItem aggregatedOrderItem : OrderItemAggregatorUtil.getAggregatedOrderItems(order)) {
            OrderItem orderItem = aggregatedOrderItem.getOrderItems().get(0);
            sb.append(
                    "<tr align='center'>"
                            + "<td>" + orderItem.getId() + "</td>"
                            + "<td>" + orderItem.getProductItem().getName() + "</td>"
                            + "<td>" + aggregatedOrderItem.getQuantity() + "</td>"
                            + "<td>" + orderItem.getProductItem().getPrice() + "</td>"
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
