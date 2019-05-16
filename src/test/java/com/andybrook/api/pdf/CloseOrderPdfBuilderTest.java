package com.andybrook.api.pdf;

import com.andybrook.generator.OrderGenerator;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.request.ctx.NotifSetting;
import com.andybrook.model.order.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.file.Path;
import java.time.ZonedDateTime;

@ContextConfiguration(classes = PdfTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CloseOrderPdfBuilderTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void generatePdfTest() {
        Order order = OrderGenerator.generateBasicOrder();
        CloseOrderPdfBuilder builder = applicationContext.getBean(CloseOrderPdfBuilder.class);
        Path path = builder.generatePdf(AggregatedOrder.toAggregatedOrder(order), new NotifSetting(true, ZonedDateTime.now(), null));
        Assert.assertNotNull(path);
        Assert.assertTrue(path.toFile().exists());
        System.out.println("PDF GENERATED : " + path.toAbsolutePath().toString());
    }
}