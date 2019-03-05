package com.andybrook.manager.customer;

import com.andybrook.model.customer.Customer;

import java.util.List;

public interface ICustomerManager {

    Customer newCustomer(Customer customer);

    List<Customer> getAll();

    Customer updateCustomer(Customer customer);
}
