package com.andybrook.dao.customer;

import com.andybrook.model.customer.Customer;

import java.util.List;
import java.util.OptionalInt;

public interface ICustomerDao {

    Customer update(Customer customer);

    Customer getById(long id);

    List<Customer> getByNameContaining(String name);

    List<Customer> getAll(OptionalInt limitOpt);
}
