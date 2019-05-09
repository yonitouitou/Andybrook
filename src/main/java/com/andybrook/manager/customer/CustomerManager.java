package com.andybrook.manager.customer;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerManager implements ICustomerManager {

    @Autowired
    private ICustomerService customerService;

    @Override
    public Customer newCustomer(AddCustomerRequest request) {
        return customerService.newCustomer(request);
    }

    @Override
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @Override
    public Map<Long, Owner> getAllOwners() {
        return customerService.getAllOwners();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerService.updateCustomer(customer);
    }
}
