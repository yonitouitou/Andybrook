package com.andybrook.service.customer;

import com.andybrook.model.customer.Customer;

import java.util.List;

public interface ICustomerService {

    Customer newCustomer(Customer customer);

    Customer getById(long id);

    List<Customer> getAll();
}

