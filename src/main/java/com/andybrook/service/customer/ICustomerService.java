package com.andybrook.service.customer;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddCustomerRequest;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

    Customer newCustomer(AddCustomerRequest request);

    Customer getById(long id);

    List<Customer> getAll();

    Map<Long, Owner> getAllOwners();

    Customer updateCustomer(Customer customer);

    Map<Long, Store> getStoresOfOwner(long ownerId);
}

