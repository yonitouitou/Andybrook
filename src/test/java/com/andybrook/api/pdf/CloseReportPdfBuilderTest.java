package com.andybrook.api.pdf;

import com.andybrook.generator.StockReportGenerator;
import com.andybrook.model.StockReport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.file.Path;

@ContextConfiguration(classes = PdfTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CloseReportPdfBuilderTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void generatePdfTest() {
        StockReport report = StockReportGenerator.generateBasicStockReport();
        CloseReportPdfBuilder builder = applicationContext.getBean(CloseReportPdfBuilder.class);
        Path path = builder.generatePdf(report);
        Assert.assertNotNull(path);
        Assert.assertTrue(path.toFile().exists());
        System.out.println("PDF GENERATED : " + path.toAbsolutePath().toString());
    }
}
