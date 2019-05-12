package com.andybrook.model.notification.event.listener;

import com.andybrook.api.email.EmailSender;
import com.andybrook.api.pdf.CloseOrderPdfBuilder;
import com.andybrook.api.pdf.IPdfBuilder;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.notification.IEmailNotification;
import com.andybrook.model.notification.OrderClosedEmailNotification;
import com.andybrook.model.notification.ctx.DocSetting;
import com.andybrook.model.notification.event.ctx.CloseOrderEvent;
import com.andybrook.model.product.Product;
import com.andybrook.model.setting.AdminSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CloseOrderEventListener implements IEventListener<CloseOrderEvent> {

    private static final Logger LOGGER = System.getLogger(CloseOrderEventListener.class.getSimpleName());
    private static final DateTimeFormatter DATE_TIME_FORMATTER_FILE_NAME = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private IAdminSettingManager adminSettingManager;

    @Override
    @EventListener
    public void handleEvent(CloseOrderEvent event) {
        IEmailNotification<AggregatedOrder> closedReportNotif = applicationContext.getBean(OrderClosedEmailNotification.class);
        AdminSetting adminSetting = adminSettingManager.getAdminSetting();
        emailSender.send(closedReportNotif.createEmail(adminSetting, event.getOrder(), getAttachmentsPaths(event.getOrder(), event.getSetting())));
    }

    private List<Path> getAttachmentsPaths(AggregatedOrder order, DocSetting setting) {
        List<Path> attachements = new LinkedList<>();
        Path csvPath = generateCsvFile(order);
        Path pdfPath = generateCloseOrderPdfFile(order, setting);
        attachements.add(csvPath);
        attachements.add(pdfPath);
        return attachements;
    }

    private Path generateCloseOrderPdfFile(AggregatedOrder order, DocSetting setting) {
        IPdfBuilder<AggregatedOrder> builder = applicationContext.getBean(CloseOrderPdfBuilder.class);
        return builder.generatePdf(order, setting);
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

}
