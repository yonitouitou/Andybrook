package com.andybrook.manager;

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
public class StockReportManagerAutomation {

    @Autowired
    private StockReportManager stockReportManager;

    @Test
    public void create10StockReports() {
        for (int i = 0; i < 200; i++) {
            long suffix = Clock.millis();
            NewStockReportRequest request = new NewStockReportRequest();
            request.setName("StockReport_" + suffix);
            request.setCustomerName("CustomerName_" + suffix);
            request.setComment("Comment_" + suffix);
            stockReportManager.newStockReport(request);
        }

    }
}
