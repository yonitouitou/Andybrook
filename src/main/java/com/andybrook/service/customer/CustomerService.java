package com.andybrook.service.customer;

import com.andybrook.dao.customer.ICustomerDao;
import com.andybrook.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerDao dao;

    @Override
    public Customer newCustomer(Customer customer) {
        return dao.update(customer);
    }

    @Override
    public Customer getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Customer> getAll() {
        return dao.getAll();
    }
}
