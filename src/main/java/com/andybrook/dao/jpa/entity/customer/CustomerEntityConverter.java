package com.andybrook.dao.jpa.entity.customer;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.store.StoreEntity;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = Customer.class, entity = CustomerEntity.class)
public class CustomerEntityConverter implements IEntityConverter<Customer, CustomerEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Customer toModel(CustomerEntity entity) {
        Store store = entityFactory.createStore(entity.getStoreEntity());
        return new Customer(entity.getId(), store);
    }

    @Override
    public CustomerEntity toEntity(Customer model) {
        StoreEntity storeEntity = entityFactory.createStoreEntity(model.getStore());
        return new CustomerEntity(model.getId(), storeEntity);
    }
}
