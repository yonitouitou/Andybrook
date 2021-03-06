package com.andybrook.service.api;

import com.andybrook.ApplicationProperties;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.model.api.StockItemsFileUpload.ProductToUpload;
import com.andybrook.util.ProductItemFileUploadGenerator;
import com.andybrook.util.clock.Clock;
import com.andybrook.util.file.FileUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StockItemsFileParserServiceTest {

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private StockItemsFileParserService stockItemsFileParserService;

    @Test
    public void processValidFileTest() throws IOException {
        StringBuilder sb = new StringBuilder(getColumnsRow()).append(System.lineSeparator())
                .append("A1;12.3;abcd123,def456,ghi789").append(System.lineSeparator())
                .append("A2;199;po42,adfib94,afnaigfn0a,aoifm976,qwrf454").append(System.lineSeparator())
                .append("A3;46;bnz134,nap442,apf13,afm5,afmpa6");
        File file = null;
        try {
            file = File.createTempFile("" + System.currentTimeMillis(), ".csv");
            FileUtil.writeToFile(file, sb.toString());
            StockItemsFileUpload result = stockItemsFileParserService.parseFile(file);
            Assert.assertEquals("RowsInFile", 3, result.getRowsInFile());
            Assert.assertEquals("RowsProcessed", 3, result.getRowsProcessed());
            Assert.assertEquals("ProductItemSize", 13, result.getProductsForUpload().size());
        } finally {
            if (file != null) {
                file.delete();
            }
        }
    }

    @Test
    public void contentFileTest() throws IOException {
        String name = "A1";
        double price = 125.99;
        String bc1 = "abcd123";
        String bc2 = "def456-afan213-efn";
        String bc3 = "ghi7890afnafk";
        StringBuilder sb = new StringBuilder(getColumnsRow()).append(System.lineSeparator())
                .append(name).append(";").append(price).append(";")
                .append(bc1).append(",").append(bc2).append(",").append(bc3);
        File file = null;
        try {
            file = File.createTempFile("" + System.currentTimeMillis(), ".csv");
            FileUtil.writeToFile(file, sb.toString());
            StockItemsFileUpload result = stockItemsFileParserService.parseFile(file);
            Assert.assertEquals("ProductItemSize", 3, result.getProductsForUpload().size());
            assertContentResult(result.getProductsForUpload().get(0), name, price, bc1);
            assertContentResult(result.getProductsForUpload().get(1), name, price, bc2);
            assertContentResult(result.getProductsForUpload().get(2), name, price, bc3);
        } finally {
            if (file != null) {
                file.delete();
            }
        }
    }

    @Test
    public void processFileIgnoreInvalidRowTest() throws IOException {
        StringBuilder sb = new StringBuilder(getColumnsRow()).append(System.lineSeparator())
                .append("A1;12.3;abcd123,def456,ghi789").append(System.lineSeparator())
                .append("A2;199;po42,adfib94,afnaigfn0a,aoifm976,qwrf454").append(System.lineSeparator())
                .append("A3");
        File file = null;
        try {
            file = File.createTempFile("" + Clock.millis(), ".csv");
            FileUtil.writeToFile(file, sb.toString());
            StockItemsFileUpload result = stockItemsFileParserService.parseFile(file);
            Assert.assertEquals("RowsInFile", 3, result.getRowsInFile());
            Assert.assertEquals("RowsProcessed", 2, result.getRowsProcessed());
            Assert.assertEquals("ProductItemSize", 8, result.getProductsForUpload().size());
        } finally {
            if (file != null) {
                file.delete();
            }
        }
    }

    @Test
    public void processFileUntilLimitItems() throws IOException {
        File file = ProductItemFileUploadGenerator.generateProductFile(applicationProperties.getStockItemFileUploadLimitItems() + 100);
        try {
            StockItemsFileUpload result = stockItemsFileParserService.parseFile(file);
            Assert.assertEquals("ProductItemSize", applicationProperties.getStockItemFileUploadLimitItems(), result.getProductsForUpload().size());
        } finally {
            if (file != null) {
                file.delete();
            }
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void parseFileNotExistsTest() throws IOException {
        stockItemsFileParserService.processCsvFile(new File(FileUtil.TMP_DIRECTORY, "test"));
    }

    @Test
    //@Ignore
    public void generateStockItemFileUpload() throws IOException {
        File file = ProductItemFileUploadGenerator.generateProductFile(15000);
        System.out.println(file.getAbsolutePath());
    }

    private void assertContentResult(ProductToUpload actual, String name, double price, String barCode) {
        Assert.assertEquals("Name", name, actual.getName());
        Assert.assertEquals("Price", price, actual.getPrice(), 0d);
        Assert.assertEquals("BarCode", barCode, actual.getBarCode().get());
    }

    public static String getColumnsRow() {
        return "Name;Price;BarCodes";
    }
}
