package com.andybrook.dao.customer;

import com.andybrook.model.customer.Customer;

import java.util.List;

public interface ICustomerDao {

    Customer update(Customer customer);

    Customer getById(long id);

    List<Customer> getAll();
}
