package com.andybrook.manager.customer;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddCustomerRequest;

import java.util.List;
import java.util.Map;

public interface ICustomerManager {

    Customer newCustomer(AddCustomerRequest request);

    Customer get(long id);

    List<Customer> getByNameContaining(String name);

    List<Customer> getAll();

    Map<Long, Owner> getAllOwners();

    Customer updateCustomer(Customer customer);

    Map<Long, Store> getStoresOfOwner(long ownerId);
}
