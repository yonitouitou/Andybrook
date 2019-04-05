package com.andybrook.model.notification;

import com.andybrook.ApplicationProperties;
import com.andybrook.api.pdf.CloseReportPdfBuilder;
import com.andybrook.api.pdf.IPdfBuilder;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.api.Email;
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
import java.util.Collection;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StockClosedEmailNotification implements IEmailNotification<Order> {

    private static final Logger LOGGER = System.getLogger(StockClosedEmailNotification.class.getSimpleName());
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

    private Path[] getAttachmentsPaths(Order report) {
        Path csvPath = generateCsvFile(report);
        Path pdfPath = generatePdfFile(report);
        return new Path[] {csvPath, pdfPath};
    }

    private Path generatePdfFile(Order report) {
        IPdfBuilder<Order> builder = applicationContext.getBean(CloseReportPdfBuilder.class);
        return builder.generatePdf(report);
    }

    private Path generateCsvFile(Order report) {
        Path csvFilePath = null;
        try {
            String content = generateCsvFileContent(report);
            csvFilePath = writeCsvInFile(report, content);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Exception occurred generating the attachment CSV file for report : ["
                    + report.getId() + ", " + report.getName() + "]");
        }
        return csvFilePath;
    }

    private String generateCsvFileContent(Order report) {
        StringBuilder sb = new StringBuilder();
        appendColumnsName(sb);
        sb.append(System.lineSeparator());
        appendStockItemsRows(sb, report.getItems());
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

    private void appendStockItemsRows(StringBuilder sb, Collection<OrderItem<? extends Product>> items) {
        items.forEach(item -> {
            generateStockItemCsvRow(sb, item);
        });
    }

    private void generateStockItemCsvRow(StringBuilder sb, OrderItem<? extends Product> item) {
        sb.append(item.getId()).append(",")
                .append(item.getProduct().getName()).append(",")
                .append(item.getQuantity()).append(",")
                .append(item.getProduct().getPrice())
                .append(System.lineSeparator());
    }

    private String getBody(Order report) {
        StringBuilder sb = new StringBuilder();
        sb.append("Report " + report.getId() + " has been closed on " + getFormattedDateTime(ZonedDateTime.now(ZoneId.of("Europe/Paris"))));
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
                        + "<td>" + report.getId() + "</td>"
                        + "<td>" + report.getName() + "</td>"
                        + "<td>" + report.getTotalQuantity() + "</td>"
                        + "<td>" + report.getTotalPrice() + " €</td>"
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

        for (OrderItem<? extends Product> item: report.getItems()) {
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
