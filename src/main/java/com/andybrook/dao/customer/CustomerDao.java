package com.andybrook.dao.customer;

import com.andybrook.dao.jpa.crudrepository.ICustomerJpaRepository;
import com.andybrook.dao.jpa.entity.customer.CustomerEntity;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.exception.CustomerNotFound;
import com.andybrook.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerDao implements ICustomerDao {

    @Autowired
    private ICustomerJpaRepository customerJpaRepository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Customer update(Customer customer) {
        CustomerEntity entity = entityFactory.createCustomerEntity(customer);
        CustomerEntity savedEntity = customerJpaRepository.save(entity);
        return entityFactory.createCustomer(savedEntity);
    }

    @Override
    public Customer getById(long id) {
        Customer customer;
        Optional<CustomerEntity> entityOpt = customerJpaRepository.findById(id);
        if (entityOpt.isPresent()) {
            customer = entityFactory.createCustomer(entityOpt.get());
        } else {
            throw new CustomerNotFound(id);
        }
        return customer;
    }
}
