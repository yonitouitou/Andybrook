package com.andybrook.api.rest;

import com.andybrook.manager.customer.ICustomerManager;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderInfo;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;

@RestController
@RequestMapping("v1/customer")
public class CustomerController extends AbstractController {

    private static Logger LOGGER = System.getLogger(CustomerController.class.getSimpleName());

    @Autowired
    private ICustomerManager customerManager;

    @PostMapping(path = "/add")
    public Customer newCustomer(@RequestBody Customer customer) {
        LOGGER.log(Level.INFO, "New Customer request : " + customer);
        return customerManager.newCustomer(customer);
    }

    @PostMapping(path = "/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        LOGGER.log(Level.INFO, "Update Customer request : " + customer);
        return customerManager.updateCustomer(customer);
    }

    @GetMapping(path = "/all")
    public List<Customer> getAll() {
        LOGGER.log(Level.INFO, "Get All customer request.");
        return customerManager.getAll();
    }
}
