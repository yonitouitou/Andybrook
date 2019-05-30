package com.andybrook.service.customer;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.model.request.customer.UpdateCustomerRequest;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public interface ICustomerService {

    Customer newCustomer(AddCustomerRequest request);

    Customer updateCustomer(UpdateCustomerRequest request);

    Customer getById(long id);

    List<Customer> getByNameContaining(String name);

    List<Customer> getAll(OptionalInt limitOpt);

    Map<Long, Owner> getAllOwners();

    Map<Long, Store> getStoresOfOwner(long ownerId);
}

