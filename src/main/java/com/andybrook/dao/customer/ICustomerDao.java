package com.andybrook.dao.customer;

import com.andybrook.model.customer.Customer;

public interface ICustomerDao {

    Customer update(Customer customer);

    Customer getById(long id);
}
