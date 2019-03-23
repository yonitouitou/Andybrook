package com.andybrook.service.customer;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.service.customer.ICustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    @Autowired
    private ICustomerService customerService;

    @Test
    public void create10customers() {
        for (int i = 0; i < 10; i++) {
            Customer c = new Customer(
                    new Store("Name-" + i, "name-" + i + "@gmail.com", "address",
                            new Owner("Michael", "Jordan", "a@gmail.com")));
            customerService.newCustomer(c);
        }
    }
}
