package com.andybrook.dao.store;

import com.andybrook.dao.jpa.crudrepository.IStoreJpaRepository;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.store.StoreEntity;
import com.andybrook.model.customer.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StoreDao implements IStoreDao {

    @Autowired
    private IStoreJpaRepository storeJpaRepository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Store update(Store store) {
        StoreEntity entity = entityFactory.createStoreEntity(store);
        StoreEntity savedEntity = storeJpaRepository.save(entity);
        return entityFactory.createStore(savedEntity);
    }

    @Override
    public Optional<Store> find(long id) {
        Optional<Store> storeOpt = Optional.empty();
        Optional<StoreEntity> storeEntityOpt = storeJpaRepository.findById(id);
        if (storeEntityOpt.isPresent()) {
            storeOpt = Optional.of(entityFactory.createStore(storeEntityOpt.get()));
        }
        return storeOpt;
    }

    @Override
    public Store get(long id) {
        StoreEntity entity = storeJpaRepository.getOne(id);
        return entityFactory.createStore(entity);
    }
}
