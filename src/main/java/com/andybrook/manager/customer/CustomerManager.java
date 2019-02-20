package com.andybrook.manager.customer;

import com.andybrook.model.customer.Customer;
import com.andybrook.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerManager implements ICustomerManager {

    @Autowired
    private ICustomerService customerService;

    @Override
    public Customer newCustomer(Customer customer) {
        Objects.requireNonNull(customer);
        return customerService.newCustomer(customer);
    }
}