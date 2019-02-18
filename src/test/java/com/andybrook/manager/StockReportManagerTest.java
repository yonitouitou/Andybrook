package com.andybrook.manager;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.manager.stock.StockReportManager;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.util.clock.Clock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StockReportManagerTest {

    @Autowired
    private StockReportManager stockReportManager;

    @Test
    public void create15StockReports() throws StoreNotFound {
        long customerId = 2;
        for (int i = 0; i < 15; i++) {
            long suffix = Clock.millis();
            NewStockReportRequest request = new NewStockReportRequest();
            request.setName("StockReport_" + suffix);
            request.setCustomerId(customerId);
            request.setComment("Comment_" + suffix);
            stockReportManager.newStockReport(request);
        }

    }
}
