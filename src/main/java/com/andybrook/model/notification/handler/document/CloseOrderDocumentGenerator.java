package com.andybrook.model.notification.handler.document;

import com.andybrook.ApplicationProperties;
import com.andybrook.annotation.DocumentGenerator;
import com.andybrook.api.pdf.CloseOrderPdfBuilder;
import com.andybrook.api.pdf.IPdfBuilder;
import com.andybrook.enums.DocType;
import com.andybrook.enums.FileFormat;
import com.andybrook.exception.UnsupportedFormatFile;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderInfo;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.notification.request.ctx.DocumentCtx;
import com.andybrook.model.notification.request.ctx.DocumentRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import com.andybrook.model.product.Product;
import com.andybrook.service.order.IOrderService;
import com.andybrook.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@DocumentGenerator(type = DocType.ORDER_FORM)
public class CloseOrderDocumentGenerator implements IDocumentGenerator {

    private static final Logger LOGGER = System.getLogger(CloseOrderDocumentGenerator.class.getSimpleName());
    private static final DateTimeFormatter DATE_TIME_FORMATTER_FILE_NAME = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private IOrderService orderService;

    @Override
    public List<Path> generate(DocumentRequest request) {
        return request.getFormats()
                .stream()
                .map(f -> generateDocument(f, request.getCtx()))
                .collect(Collectors.toList());
    }

    public Path generateDocument(FileFormat format, DocumentCtx ctx) {
        Path path;
        OrderDocumentCtx docCtx = (OrderDocumentCtx) ctx;
        Order order = docCtx.getOrder();
        switch (format) {
            case PDF:
                AggregatedOrder aggregatedOrder = orderService.aggregate(order);
                path = generatePdfFile(aggregatedOrder, docCtx);
                break;
            case CSV:
                aggregatedOrder = orderService.aggregate(order);
                path = generateCsvFile(aggregatedOrder);
                break;
            default:
                throw new UnsupportedFormatFile(format);
        }
        return path;
    }

    private Path generatePdfFile(AggregatedOrder order, OrderDocumentCtx ctx) {
        IPdfBuilder builder = applicationContext.getBean(CloseOrderPdfBuilder.class);
        return builder.generatePdf(ctx);
    }

    private Path generateCsvFile(AggregatedOrder order) {
        AggregatedOrderInfo orderInfo = order.getAggregatedOrderInfo();
        Path csvFilePath = null;
        try {
            String content = generateCsvFileContent(order);
            csvFilePath = writeCsvInFile(order, content);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Exception occurred generating the attachment CSV file for report : ["
                    + orderInfo.getId() + ", " + orderInfo.getName() + "]");
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
        AggregatedOrderInfo orderInfo = order.getAggregatedOrderInfo();
        ZonedDateTime datetime = DateUtil.epochTimeInMillisToZdt(orderInfo.getCreatedDatetime(), applicationProperties.getZoneId());
        String fileName = orderInfo.getName() + "-" + datetime.format(DATE_TIME_FORMATTER_FILE_NAME);
        File tmpFile = File.createTempFile(fileName, ".csv");
        try (FileWriter writer = new FileWriter(tmpFile)) {
            writer.write(csv);
            writer.flush();
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
