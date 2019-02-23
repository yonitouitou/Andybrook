package com.andybrook.init;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.manager.stock.OrderManager;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.util.clock.Clock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InitSystemTest {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private OrderManager stockReportManager;

    @Test
    public void initSystem() throws Exception {
        Customer customer = createCustomer();
        create15StockReports(customer);
    }

    private Customer createCustomer() {
        Owner owner = new Owner("Steve", "Smith", "steve.smith@optika.net");
        Store store = new Store("Optika", "optika@gmail.com", "13 Avenue Paul Valery - Paris", owner);
        Customer customer = new Customer(store);
        return customerService.newCustomer(customer);
    }

    public void create15StockReports(Customer customer) throws StoreNotFound {
        for (int i = 0; i < 15; i++) {
            long suffix = Clock.millis();
            NewStockReportRequest request = new NewStockReportRequest();
            request.setName("StockReport_" + suffix);
            request.setCustomerId(customer.getId());
            request.setComment("Comment_" + suffix);
            stockReportManager.newStockReport(request);
        }
    }

}
