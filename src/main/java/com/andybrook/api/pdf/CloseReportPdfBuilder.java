package com.andybrook.api.pdf;

import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.product.Product;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class CloseReportPdfBuilder implements IPdfBuilder<StockReport> {

    private static final int NUMBER_OF_COLUMNS_4 = 4;
    private static final float BORDER_WITH_2 = 2;
    private static final String[] COLUMNS_NAME = {"ID", "Name", "Quantity", "Price"};
    private static final BaseColor HEADER_BACKGROUND_COLOR = BaseColor.LIGHT_GRAY;

    @Override
    public Path generatePdf(StockReport report) {
        String fileName = report.getName() + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Path pdfFilePath = null;
        Document document = new Document();
        PdfWriter writer = null;
        try {
            pdfFilePath = Files.createTempFile(fileName, ".pdf");
            System.err.println("PDF File path : " + pdfFilePath.toAbsolutePath().toString());
            writer = PdfWriter.getInstance(document,
                    new FileOutputStream(pdfFilePath.toFile()));

            document.open();

            PdfPTable table = new PdfPTable(NUMBER_OF_COLUMNS_4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            addTableHeader(table);
            addRows(table, report);

            document.add(table);
            document.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        } finally {
            if (writer != null && ! writer.isCloseStream()) {
                writer.close();
            }
            if (document.isOpen()) {
                document.close();
            }
        }
        return pdfFilePath;
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of(COLUMNS_NAME)
                .forEachOrdered(col -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(HEADER_BACKGROUND_COLOR);
                    header.setBorderWidth(BORDER_WITH_2);
                    header.setPhrase(new Phrase(col));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, StockReport report) {
        for (StockItem<? extends Product> item : report.getItems()) {
            table.addCell(new PdfPCell(new Phrase(String.valueOf(item.getId()))));
            table.addCell(new PdfPCell(new Phrase(item.getProduct().getName())));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(item.getQuantity()))));
            table.addCell(new PdfPCell(new Phrase(item.getProduct().getPrice() + "€")));
        }
    }
}
