package com.andybrook.dao.owner;

import com.andybrook.dao.jpa.repository.IOwnerCrudRepository;
import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.model.customer.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static com.andybrook.util.PerfConst.OWNER_SIZE_512;

@Repository
public class OwnerDao implements IOwnerDao {

    @Autowired
    private IOwnerCrudRepository repository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Map<Long, Owner> getAll() {
        Map<Long, Owner> owners = new HashMap<>(OWNER_SIZE_512);
        Iterable<OwnerEntity> it = repository.findAll();
        it.forEach(entity -> {
            Owner owner = entityFactory.createOwner(entity);
            owners.put(owner.getId(), owner);
        });
        return owners;
    }

    @Override
    public Owner update(Owner owner) {
        OwnerEntity entity = entityFactory.createOwnerEntity(owner);
        OwnerEntity savedEntity = repository.save(entity);
        return entityFactory.createOwner(savedEntity);
    }
}
