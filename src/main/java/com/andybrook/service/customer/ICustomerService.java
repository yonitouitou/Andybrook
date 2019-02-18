package com.andybrook.service.customer;

import com.andybrook.model.customer.Customer;

public interface ICustomerService {

    Customer newCustomer(Customer customer);

    Customer getById(long id);
}
