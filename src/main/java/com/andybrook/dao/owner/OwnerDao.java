package com.andybrook.dao.owner;

import com.andybrook.dao.jpa.crudrepository.IOwnerCrudRepository;
import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.model.customer.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerDao implements IOwnerDao {

    @Autowired
    private IOwnerCrudRepository customerCrudRepository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Owner update(Owner owner) {
        OwnerEntity entity = entityFactory.createOwnerEntity(owner);
        OwnerEntity savedEntity = customerCrudRepository.save(entity);
        return entityFactory.createOwner(savedEntity);
    }
}
