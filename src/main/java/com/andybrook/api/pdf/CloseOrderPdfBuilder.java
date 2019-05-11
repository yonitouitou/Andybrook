package com.andybrook.api.pdf;

import com.andybrook.language.Msg.Pdf;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@Component
public class CloseOrderPdfBuilder extends AbstractPdfBuilder implements IPdfBuilder<AggregatedOrder> {

    private static final Logger LOGGER = System.getLogger(CloseOrderPdfBuilder.class.getSimpleName());
    private static final NumberFormat PRICE_FORMATTER = new DecimalFormat("#0.00");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final int NUMBER_OF_COLUMNS_5 = 5;
    private static final float PADDING_3 = 3;
    private static final float TITLE_FONT_SIZE_20 = 20;
    private static final float SUB_TITLE_FONT_SIZE_15 = 15;
    private static final float TEXT_FONT_SIZE_11 = 11;
    private static final String[] COLUMNS_NAME_ITEMS = new String[5];
    private static final String[] COLUMNS_NAME_CUSTOMER_MAIN_DETAILS = new String[2];
    private static final String[] COLUNS_NAME_CUSTOMER_CONTACT_DETAILS = new String[4];
    private static final FontFamily FONT_TYPE_TIMES_ROMAN = FontFamily.TIMES_ROMAN;

    private static BaseColor headerBackgroundColor;
    private static BaseColor headerTextColor;

    @PostConstruct
    protected void init() {
        super.init();
        headerBackgroundColor = new BaseColor(adminSetting.getDocumentHeaderTableBackgroundColor().getRGB());
        headerTextColor = new BaseColor(adminSetting.getDocumentHeaderTableTextColor().getRGB());
        initColumnsNameItems();
        initColumnsCustomerMainDetails();
        initColumnsCustomerContactDetails();
    }

    @Override
    public Path generatePdf(AggregatedOrder order) {
        String fileName = order.getName() + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Path pdfFilePath = null;
        Document document = new Document(PageSize.A4, 20f, 20f, 7f, 7f);
        PdfWriter writer = null;
        try {
            pdfFilePath = Files.createTempFile(fileName, ".pdf");
            System.err.println("PDF File path : " + pdfFilePath.toAbsolutePath().toString());
            writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath.toFile()));

            document.open();

            Element logo = importLogoAndybrook();
            Element title = createTitle(order);
            Element customerTable1 = createCustomerMainDetailsTable(order);
            Element customerTable2 = createCustomerContactDetailsTable(order);
            Element itemsTable = createItemsTable(order);
            Element doneDate = createDoneDate();
            Element signature = createSignatureTable();

            document.add(logo);
            document.add(title);
            addEmptyRow(document, 1);
            document.add(customerTable1);
            document.add(customerTable2);
            addEmptyRow(document, 1);
            document.add(itemsTable);
            addEmptyRow(document, 1);
            document.add(doneDate);
            document.add(signature);
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
        String name = languageResolver.get(Pdf.NAME);
        String quantity = languageResolver.get(Pdf.QUANTITY);
        String price = languageResolver.get(Pdf.UNIT_PRICE);
        String ttlPrice = languageResolver.get(Pdf.TOTAL);
        COLUMNS_NAME_ITEMS[0] = "#";
        COLUMNS_NAME_ITEMS[1] = name;
        COLUMNS_NAME_ITEMS[2] = quantity;
        COLUMNS_NAME_ITEMS[3] = price;
        COLUMNS_NAME_ITEMS[4] = ttlPrice;
    }

    private void initColumnsCustomerMainDetails() {
        String compagnyName = languageResolver.get(Pdf.COMPAGNY);
        String ownerName = languageResolver.get(Pdf.OWNER_NAME);
        COLUMNS_NAME_CUSTOMER_MAIN_DETAILS[0] = compagnyName;
        COLUMNS_NAME_CUSTOMER_MAIN_DETAILS[1] = ownerName;
    }

    private void initColumnsCustomerContactDetails() {
        String address = languageResolver.get(Pdf.ADDRESS);
        String phoneNumber = languageResolver.get(Pdf.PHONE_NUMBER);
        String email = languageResolver.get(Pdf.EMAIL_ADDRESS);
        String shopName = languageResolver.get(Pdf.SHOP_NAME);
        COLUMNS_NAME_CUSTOMER_MAIN_DETAILS[0] = shopName;
        COLUNS_NAME_CUSTOMER_CONTACT_DETAILS[1] = address;
        COLUNS_NAME_CUSTOMER_CONTACT_DETAILS[2] = phoneNumber;
        COLUNS_NAME_CUSTOMER_CONTACT_DETAILS[3] = email;
    }

    private Element importLogoAndybrook() throws IOException, DocumentException {
        Image logo = Image.getInstance(ResourceUtils.getFile("classpath:images/andybrook-logo.jpg").getAbsolutePath());
        logo.setAlignment(Element.ALIGN_CENTER);
        logo.setWidthPercentage(20);
        logo.setScaleToFitHeight(true);
        return logo;
    }


    private Element createTitle(AggregatedOrder order) {
        Paragraph title = new Paragraph();

        Chunk subTitleId = new Chunk(languageResolver.get(Pdf.ORDER_FORM).toUpperCase() + " #" + order.getId());
        subTitleId.setUnderline(0.1f, -2f);
        subTitleId.setFont(new Font(FONT_TYPE_TIMES_ROMAN, TITLE_FONT_SIZE_20, Font.BOLD, headerTextColor));

        Chunk subTitleName = new Chunk(order.getName());
        subTitleName.setFont(new Font(FONT_TYPE_TIMES_ROMAN, SUB_TITLE_FONT_SIZE_15, Font.ITALIC, headerTextColor));

        title.setAlignment(Element.ALIGN_CENTER);
        title.add(subTitleId);
        title.add(Chunk.NEWLINE);
        title.add(subTitleName);

        return title;
    }

    private Element createCustomerMainDetailsTable(AggregatedOrder order) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        float[] columnWidths = {1f, 1f};
        table.setWidths(columnWidths);
        addTableHeader(table, COLUMNS_NAME_CUSTOMER_MAIN_DETAILS);
        addCustomerDetailsFirstRow(table, order);
        return table;
    }

    private Element createCustomerContactDetailsTable(AggregatedOrder order) throws DocumentException {
        PdfPTable table2 = new PdfPTable(4);
        table2.setWidthPercentage(100);
        table2.setSpacingAfter(10f);
        float[] columnWidths2 = {1f, 1f, 1f, 1f};
        table2.setWidths(columnWidths2);
        addTableHeader(table2, COLUNS_NAME_CUSTOMER_CONTACT_DETAILS);
        addCustomerDetailsSecondRow(table2, order);
        return table2;
    }

    private Element createItemsTable(AggregatedOrder order) throws DocumentException {
        PdfPTable table = new PdfPTable(NUMBER_OF_COLUMNS_5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        float[] columnWidths = {0.2f, 2f, 0.5f, 0.5f, 0.5f};
        table.setWidths(columnWidths);

        addTableHeader(table, COLUMNS_NAME_ITEMS);
        addRows(table, order);

        return table;
    }

    private void addCustomerDetailsFirstRow(PdfPTable table, AggregatedOrder order) {
        Store store = order.getCustomer().getStore();
        Owner owner = store.getOwner();
        table.addCell(getStringCell(owner.getCompagnyName()));
        table.addCell(getStringCell(owner.getFirstName() + " " + owner.getLastName()));
    }

    private void addCustomerDetailsSecondRow(PdfPTable table, AggregatedOrder order) {
        Store store = order.getCustomer().getStore();
        table.addCell(getStringCell(store.getName()));
        table.addCell(getStringCell(store.getAddress()));
        table.addCell(getStringCell(store.getPhone()));
        table.addCell(getStringCell(store.getEmail()));
    }

    private void addTableHeader(PdfPTable table, String[] columnsName) {
        Stream.of(columnsName)
                .forEachOrdered(col -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(headerBackgroundColor);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setVerticalAlignment(Element.ALIGN_CENTER);
                    header.setPhrase(new Phrase(col, new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11, Font.BOLD, headerTextColor)));
                    header.setPadding(PADDING_3);
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, AggregatedOrder order) {
        for (int i = 0; i < order.getAggregatedOrderItems().size(); i++) {
            AggregatedOrderItem item = order.getAggregatedOrderItems().get(i);
            table.addCell(getStringCell(String.valueOf(i + 1)));
            table.addCell(getStringCell(item.getProduct().getName()));
            table.addCell(getNumericCell(String.valueOf(item.getQuantity())));
            table.addCell(getNumericCell(PRICE_FORMATTER.format(item.getProduct().getPrice()) + " €"));
            table.addCell(getNumericCell(PRICE_FORMATTER.format(item.getTtlPrice()) + " €"));
        }
        PdfPCell totalCell = new PdfPCell(new Phrase
                                (languageResolver.get(Pdf.TOTAL).toUpperCase(),
                                new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11, Font.BOLD)));
        totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        totalCell.setVerticalAlignment(Element.ALIGN_CENTER);
        totalCell.setPadding(PADDING_3);
        totalCell.setColspan(2);
        table.addCell(totalCell);

        PdfPCell emptyCell = getEmptyCell();
        emptyCell.setColspan(2);
        emptyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(emptyCell);

        PdfPCell ttlPriceCell = new PdfPCell(new Phrase(
                        PRICE_FORMATTER.format(order.getAggregatedOrderInfo().getTotalPrice()) + "€",
                                new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11, Font.BOLD)));
        ttlPriceCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ttlPriceCell.setVerticalAlignment(Element.ALIGN_CENTER);
        ttlPriceCell.setPadding(PADDING_3);
        table.addCell(ttlPriceCell);
    }

    private Element createDoneDate() {
        Paragraph p = new Paragraph();
        String msg = languageResolver.get(Pdf.DONE_ON_DATE) + " " + languageResolver.getNowDateByZone().format(DATE_FORMATTER);
        Element phrase = new Phrase(msg, new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11, Font.ITALIC));
        p.add(phrase);
        p.setAlignment(Element.ALIGN_RIGHT);
        p.setSpacingAfter(3f);
        return p;
    }

    private Element createSignatureTable() { ;
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(50);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        PdfPCell signCell = new PdfPCell(new Phrase(languageResolver.get(Pdf.SIGNATURE) + " :", new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11, Font.ITALIC)));
        signCell.setPadding(5f);
        signCell.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
        signCell.setBorderWidth(1f);

        PdfPCell emptyCell = getEmptyCell();
        emptyCell.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);
        emptyCell.setBorderWidth(1f);
        emptyCell.setFixedHeight(55f);

        table.addCell(signCell);
        table.addCell(emptyCell);
        return table;
    }

    private PdfPCell getEmptyCell() {
        return new PdfPCell();
    }

    private PdfPCell getNumericCell(String value) {
        Phrase phrase = new Phrase(value, new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11));
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(PADDING_3);
        return cell;
    }

    private PdfPCell getStringCell(String value) {
        Phrase phrase = new Phrase(value, new Font(FontFamily.TIMES_ROMAN, TEXT_FONT_SIZE_11));
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(PADDING_3);
        return cell;
    }

    private void addEmptyRow(Document document, int nb) throws DocumentException {
        for (int i = 0; i < nb; i++) {
            document.add(Chunk.NEWLINE);
        }
    }
}
