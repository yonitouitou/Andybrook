package com.andybrook.service;

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
    public void createCustomer() {
        Owner owner = new Owner("Steve", "Smith", "steve.smith@optika.net");
        Store store = new Store("Optika", "optika@gmail.com", "13 Avenue Paul Valery - Paris", owner);
        Customer customer = new Customer(store);
        customerService.newCustomer(customer);
    }
}
