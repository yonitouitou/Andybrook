package com.andybrook.api.rest;

import com.andybrook.manager.customer.ICustomerManager;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

@RestController
@RequestMapping("v1/customer")
public class CustomerController extends AbstractController {

    private static Logger LOGGER = System.getLogger(CustomerController.class.getSimpleName());

    @Autowired
    private ICustomerManager customerManager;

    public Customer newCustomer(Customer customer) {
        LOGGER.log(Level.INFO, "New Customer request : " + customer);
        return customerManager.newCustomer(customer);
    }
}
