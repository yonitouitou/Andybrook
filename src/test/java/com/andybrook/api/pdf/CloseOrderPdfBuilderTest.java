package com.andybrook.api.pdf;

import com.andybrook.generator.OrderGenerator;
import com.andybrook.generator.StoreGenerator;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.manager.order.OrderManager;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.customer.Store;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import com.andybrook.service.store.IStoreService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.file.Path;
import java.time.ZonedDateTime;

import static org.mockito.ArgumentMatchers.anyLong;

@ContextConfiguration(classes = PdfTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CloseOrderPdfBuilderTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    @InjectMocks
    private IOrderManager orderManager = new OrderManager();

    @Autowired
    private IStoreService storeService;

    @Test
    public void generatePdfTest() {
        Store store = StoreGenerator.generateStore();
        Order order = OrderGenerator.generateOrder(store.getId());
        Mockito.when(storeService.getById(anyLong())).thenReturn(store);
        AggregatedOrder aggregatedOrder = orderManager.aggregate(order);
        CloseOrderPdfBuilder builder = applicationContext.getBean(CloseOrderPdfBuilder.class);
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(true, order, aggregatedOrder)
                .setDateDocument(ZonedDateTime.now())
                .build();
        Path path = builder.generatePdf(ctx);
        Assert.assertNotNull(path);
        Assert.assertTrue(path.toFile().exists());
        System.out.println("PDF GENERATED : " + path.toAbsolutePath().toString());
    }
}
