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
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.StringJoiner;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StockClosedEmailNotification implements IEmailNotification<StockReport> {

    private static final Logger LOGGER = System.getLogger(StockClosedEmailNotification.class.getSimpleName());
    private static final DateTimeFormatter DATE_TIME_FORMATTER_FILE_NAME = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public Email createEmail(StockReport report) {
        return Email.builder()
                .fromAdress(applicationProperties.getNotificationEmailFrom())
                .toAdresses(applicationProperties.getNotificationEmailTo())
                .withSubject("Report " + report.getId() + " closed")
                .withBody(getBody(report))
                .withAttachmentFile(generateCsvFile(report))
                .build();

    }

    private Path generateCsvFile(StockReport report) {
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

    private String generateCsvFileContent(StockReport report) {
        StringBuilder sb = new StringBuilder();
        appendColumnsName(sb);
        sb.append(System.lineSeparator());
        appendStockItemsRows(sb, report.getItems());
        return sb.toString();
    }

    private Path writeCsvInFile(StockReport report, String csv) throws IOException {
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
        //Files.writeString(File.createTempFile(fileName, "csv").toPath(), csv, Charset.defaultCharset(), StandardOpenOption.CREATE);
        return tmpFile.toPath();
    }

    private void appendColumnsName(StringBuilder sb) {
        sb.append("Id").append(",")
            .append("Name").append(",")
            .append("quantity").append(",")
            .append("Price");
    }

    private void appendStockItemsRows(StringBuilder sb, Collection<StockItem<? extends Product>> items) {
        items.forEach(item -> {
            generateStockItemCsvRow(sb, item);
        });
    }

    private void generateStockItemCsvRow(StringBuilder sb, StockItem<? extends Product> item) {
        sb.append(item.getId()).append(",")
                .append(item.getProduct().getName()).append(",")
                .append(item.getQuantity()).append(",")
                .append(item.getProduct().getPrice())
                .append(System.lineSeparator());
    }

    private String getBody(StockReport report) {
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
