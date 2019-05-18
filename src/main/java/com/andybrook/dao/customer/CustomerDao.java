package com.andybrook.dao.customer;

import com.andybrook.dao.jpa.repository.ICustomerJpaRepository;
import com.andybrook.dao.jpa.entity.customer.CustomerEntity;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.exception.CustomerNotFound;
import com.andybrook.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Repository
public class CustomerDao implements ICustomerDao {

    @Autowired
    private ICustomerJpaRepository repository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Customer update(Customer customer) {
        CustomerEntity entity = entityFactory.createCustomerEntity(customer);
        CustomerEntity savedEntity = repository.save(entity);
        return entityFactory.createCustomer(savedEntity);
    }

    @Override
    public Customer getById(long id) {
        Customer customer;
        Optional<CustomerEntity> entityOpt = repository.findById(id);
        if (entityOpt.isPresent()) {
            customer = entityFactory.createCustomer(entityOpt.get());
        } else {
            throw new CustomerNotFound(id);
        }
        return customer;
    }

    @Override
    public List<Customer> getByNameContaining(String name) {
        List<CustomerEntity> customerEntities = repository.getCustomerByNameContaining(name);
        return customerEntities.stream()
                .map(entityFactory::createCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getAll(OptionalInt limitOpt) {
        Iterable<CustomerEntity> entities = limitOpt.isPresent()
                ? repository.findAll(PageRequest.of(0, limitOpt.getAsInt(), new Sort(Direction.ASC, "id")))
                : repository.findAll();
        List<Customer> customers = new LinkedList<>();
        entities.forEach(entity -> {
            Customer customer = entityFactory.createCustomer(entity);
            customers.add(customer);
        });
        return customers;
    }
}
