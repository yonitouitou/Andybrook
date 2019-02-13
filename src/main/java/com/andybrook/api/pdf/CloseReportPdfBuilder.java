package com.andybrook.api.pdf;

import com.andybrook.language.Msg.Pdf;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.product.Product;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@Component
public class CloseReportPdfBuilder extends AbstractPdfBuilder implements IPdfBuilder<StockReport> {

    private static final Logger LOGGER = System.getLogger(CloseReportPdfBuilder.class.getSimpleName());
    private static final int NUMBER_OF_COLUMNS_4 = 4;
    private static final float PADDING_3 = 3;
    private static final float TITLE_FONT_SIZE_14 = 14;
    private static final float TEXT_FONT_SIZE_11 = 11;
    private static final String[] COLUMNS_NAME_ITEMS = new String[4];
    private static final String[] COLUMNS_NAME_CUSTOMER_MAIN_DETAILS = new String[2];
    private static final String[] COLUNS_NAME_CUSTOMER_CONTACT_DETAILS = new String[3];
    private static final BaseColor HEADER_BACKGROUND_COLOR = new BaseColor(206, 206, 206);
    private static final BaseColor TEXT_COLOR_BLACK = BaseColor.BLACK;

    @PostConstruct
    private void init() {
        initColumnsNameItems();
        initColumnsCustomerMainDetails();
        initColumnsCustomerContactDetails();
    }

    @Override
    public Path generatePdf(StockReport report) {
        String fileName = report.getName() + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Path pdfFilePath = null;
        Document document = new Document(PageSize.A4);
        PdfWriter writer = null;
        try {
            pdfFilePath = Files.createTempFile(fileName, ".pdf");
            System.err.println("PDF File path : " + pdfFilePath.toAbsolutePath().toString());
            writer = PdfWriter.getInstance(document,
                    new FileOutputStream(pdfFilePath.toFile()));

            document.open();

            Element title = createTitle(report);
            Element customerTable1 = createCustomerMainDetailsTable(report);
            Element customerTable2 = createCustomerContactDetailsTable(report);
            Element itemsTable = createItemsTable(report);

            document.add(title);
            addEmptyRow(document, 4);
            document.add(customerTable1);
            document.add(customerTable2);
            addEmptyRow(document, 1);
            document.add(itemsTable);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "PDF Generation failed", e);
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

    private void initColumnsNameItems() {
        String id = languageResolver.get(Pdf.ID);
        String name = languageResolver.get(Pdf.NAME);
        String quantity = languageResolver.get(Pdf.QUANTITY);
        String price = languageResolver.get(Pdf.PRICE);
        COLUMNS_NAME_ITEMS[0] = id;
        COLUMNS_NAME_ITEMS[1] = name;
        COLUMNS_NAME_ITEMS[2] = quantity;
        COLUMNS_NAME_ITEMS[3] = price;
    }

    private void initColumnsCustomerMainDetails() {
        String shopName = languageResolver.get(Pdf.SHOP_NAME);
        String ownerName = languageResolver.get(Pdf.OWNER_NAME);
        COLUMNS_NAME_CUSTOMER_MAIN_DETAILS[0] = shopName;
        COLUMNS_NAME_CUSTOMER_MAIN_DETAILS[1] = ownerName;
    }

    private void initColumnsCustomerContactDetails() {
        String address = languageResolver.get(Pdf.ADDRESS);
        String phoneNumber = languageResolver.get(Pdf.PHONE_NUMBER);
        String email = languageResolver.get(Pdf.EMAIL_ADDRESS);
        COLUNS_NAME_CUSTOMER_CONTACT_DETAILS[0] = address;
        COLUNS_NAME_CUSTOMER_CONTACT_DETAILS[1] = phoneNumber;
        COLUNS_NAME_CUSTOMER_CONTACT_DETAILS[2] = email;
    }


    private Element createTitle(StockReport report) {
        Paragraph title = new Paragraph();

        Paragraph subTitleId = new Paragraph(languageResolver.get(Pdf.ORDER_FORM) + " #" + report.getId());
        subTitleId.setAlignment(Element.ALIGN_CENTER);
        subTitleId.setFont(new Font(FontFamily.TIMES_ROMAN, TITLE_FONT_SIZE_14, FontStyle.UNDERLINE.ordinal(), TEXT_COLOR_BLACK));
        subTitleId.add(Chunk.NEWLINE);

        Paragraph subTitleName = new Paragraph(report.getName());
        subTitleName.setAlignment(Element.ALIGN_CENTER);
        subTitleName.setFont(new Font(FontFamily.TIMES_ROMAN, TITLE_FONT_SIZE_14, FontStyle.UNDERLINE.ordinal(), TEXT_COLOR_BLACK));

        title.add(subTitleId);
        title.add(subTitleName);

        return title;
    }

    private Element createCustomerMainDetailsTable(StockReport report) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        float[] columnWidths = {1f, 1f};
        table.setWidths(columnWidths);
        addTableHeader(table, COLUMNS_NAME_CUSTOMER_MAIN_DETAILS);
        addCustomerDetailsFirstRow(table, report);
        return table;
    }

    private Element createCustomerContactDetailsTable(StockReport report) throws DocumentException {
        PdfPTable table2 = new PdfPTable(3);
        table2.setWidthPercentage(100);
        table2.setSpacingAfter(10f);
        float[] columnWidths2 = {1f, 1f, 1f};
        table2.setWidths(columnWidths2);
        addTableHeader(table2, COLUNS_NAME_CUSTOMER_CONTACT_DETAILS);
        addCustomerDetailsSecondRow(table2, report);
        return table2;
    }

    private Element createItemsTable(StockReport report) throws DocumentException {
        PdfPTable table = new PdfPTable(NUMBER_OF_COLUMNS_4);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        float[] columnWidths = {1f, 2f, 0.5f, 0.5f};
        table.setWidths(columnWidths);

        addTableHeader(table, COLUMNS_NAME_ITEMS);
        addRows(table, report);

        return table;
    }

    private void addCustomerDetailsFirstRow(PdfPTable table, StockReport report) {
        addStringCell(table, report.getCustomerName());
        addStringCell(table, "Jonathan Uta");
    }

    private void addCustomerDetailsSecondRow(PdfPTable table, StockReport report) {
        addStringCell(table, "12 avenue du 8 mai 1945 - 95200 Sarcelles");
        addStringCell(table, "01 39 90 12 47");
        addStringCell(table, "yoni@gmail.com");
    }

    private void addTableHeader(PdfPTable table, String[] columnsName) {
        Stream.of(columnsName)
                .forEachOrdered(col -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(HEADER_BACKGROUND_COLOR);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setVerticalAlignment(Element.ALIGN_CENTER);
                    header.setPhrase(new Phrase(col, new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11)));
                    header.setPadding(PADDING_3);
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, StockReport report) {
        for (StockItem<? extends Product> item : report.getItems()) {
            addStringCell(table, String.valueOf(item.getId()));
            addStringCell(table, item.getProduct().getName());
            addNumericCell(table, String.valueOf(item.getQuantity()));
            addNumericCell(table, item.getProduct().getPrice() + "€");
        }
    }

    private void addNumericCell(PdfPTable table, String value) {
        Phrase phrase = new Phrase(value);
        phrase.setFont(new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11));
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(PADDING_3);
        table.addCell(cell);
    }

    private void addStringCell(PdfPTable table, String value) {
        Phrase phrase = new Phrase(value);
        phrase.setFont(new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11));
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(PADDING_3);
        table.addCell(cell);
    }

    private void addLineSeparator(Document document) throws DocumentException {
        LineSeparator line = new LineSeparator();
        document.add(line);
    }

    private void addImage(Document document, String filePath) throws IOException, DocumentException {
        document.add(Image.getInstance(filePath));
    }

    private void addEmptyRow(Document document, int nb) throws DocumentException {
        for (int i = 0; i < nb; i++) {
            document.add(Chunk.NEWLINE);
        }
    }
}
