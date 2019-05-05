package com.andybrook.service.customer;

import com.andybrook.assertor.CustomerAssertor;
import com.andybrook.exception.CustomerNotFound;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.util.clock.Clock;
import org.junit.Assert;
import org.junit.Before;
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

    private Owner owner;
    private Store store;
    private Customer customer;

    @Before
    public void init() {
        long index = Clock.millis();
        owner = new Owner("Michael-" + index, "Jordan-" + index, "Owner." + index + "@gmail.com");
        store = new Store("Name" + index, "name." + index + "@gmail.com", "address", "01.43.45.32.11", owner);
        customer = new Customer(store);
    }

    @Test
    public void createSingleCustomerTest() {
        Customer savedCustomer = customerService.newCustomer(customer);
        Assert.assertNotNull(savedCustomer.getId());
        CustomerAssertor.assertEqualsStaticField(customer, savedCustomer);
    }

    @Test
    public void getCustomerTest() {
        Customer savedCustomer = customerService.newCustomer(customer);
        Customer getCustomer = customerService.getById(savedCustomer.getId());
        CustomerAssertor.assertEquals(savedCustomer, getCustomer);
    }

    @Test
    public void updateCustomerTest() {
        customer = customerService.newCustomer(customer);
        Store store = customer.getStore();
        store.setAddress("NewAddress");
        store.setEmail("NewEmail@gmail.com");
        store.setName("NewName");
        Owner owner = store.getOwner();
        owner.setEmail("NewStoreEmail@gmail.com");
        owner.setFirstName("NewFirstName");
        owner.setLastName("NewLastName");
        Customer updatedCustomer = customerService.updateCustomer(this.customer);
        CustomerAssertor.assertEquals(customer, updatedCustomer);
    }

    @Test(expected = CustomerNotFound.class)
    public void getInexistentCustomerTest() {
        customerService.getById(Long.MAX_VALUE);
    }


}
