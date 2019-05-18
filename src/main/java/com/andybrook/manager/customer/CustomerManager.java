package com.andybrook.manager.customer;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

@Service
public class CustomerManager implements ICustomerManager {

    @Autowired
    private ICustomerService customerService;

    @Override
    public Customer newCustomer(AddCustomerRequest request) {
        return customerService.newCustomer(request);
    }

    @Override
    public Customer get(long id) {
        return customerService.getById(id);
    }

    @Override
    public List<Customer> getByNameContaining(String name) {
        return customerService.getByNameContaining(name);
    }

    @Override
    public List<Customer> getAll(OptionalInt limitOpt) {
        return customerService.getAll(limitOpt);
    }

    @Override
    public Map<Long, Owner> getAllOwners() {
        return customerService.getAllOwners();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @Override
    public Map<Long, Store> getStoresOfOwner(long ownerId) {
        return customerService.getStoresOfOwner(ownerId);
    }
}
