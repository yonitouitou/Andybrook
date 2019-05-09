package com.andybrook.service.customer;

import com.andybrook.dao.customer.ICustomerDao;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.request.customer.AddCustomerRequest;
import com.andybrook.service.owner.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerDao dao;
    @Autowired
    private IOwnerService ownerService;

    @Override
    public Customer newCustomer(AddCustomerRequest request) {
        return update(request.toCustomer());
    }

    @Override
    public Customer getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Customer> getAll() {
        return dao.getAll();
    }

    @Override
    public Map<Long, Owner> getAllOwners() {
        return ownerService.getAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return update(customer);
    }

    private Customer update(Customer customer) {
        return dao.update(customer);
    }
}
