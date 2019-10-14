package com.andybrook.dao.store;

import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import com.andybrook.dao.jpa.repository.IStoreJpaRepository;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.store.StoreEntity;
import com.andybrook.dao.owner.IOwnerDao;
import com.andybrook.model.customer.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StoreDao implements IStoreDao {

    @Autowired
    private IStoreJpaRepository repository;
    @Autowired
    private IOwnerDao ownerDao;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Store update(Store store) {
        ownerDao.update(store.getOwner());
        StoreEntity entity = entityFactory.createStoreEntity(store);
        StoreEntity savedEntity = repository.save(entity);
        return entityFactory.createStore(savedEntity);
    }

    @Override
    public Optional<Store> find(long id) {
        Optional<Store> storeOpt = Optional.empty();
        Optional<StoreEntity> storeEntityOpt = repository.findById(id);
        if (storeEntityOpt.isPresent()) {
            storeOpt = Optional.of(entityFactory.createStore(storeEntityOpt.get()));
        }
        return storeOpt;
    }

    @Override
    public Store get(long id) {
        StoreEntity entity = repository.getOne(id);
        return entityFactory.createStore(entity);
    }

    @Override
    public boolean exists(long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Store> getByNameContaining(String name) {
        List<StoreEntity> entities = repository.getStoreByNameContaining(name);
        return entities.stream()
                .map(entityFactory::createStore)
                .collect(Collectors.toList());
    }

    @Override
    public List<Store> getAll(OptionalInt limitOpt) {
        Iterable<StoreEntity> entities = limitOpt.isPresent()
                ? repository.findAll(PageRequest.of(0, limitOpt.getAsInt(), new Sort(Sort.Direction.ASC, "id")))
                : repository.findAll();
        List<Store> stores = new LinkedList<>();
        entities.forEach(entity -> {
            Store store = entityFactory.createStore(entity);
            stores.add(store);
        });
        return stores;
    }

    @Override
    public Map<Long, Store> getStoresOfOwner(long ownerId) {
        Map<Long, Store> stores = new HashMap<>();
        OwnerEntity ownerEntity = ownerDao.getOne(ownerId);
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setOwnerEntity(ownerEntity);
        List<StoreEntity> entities = repository.findAll(Example.of(storeEntity));
        entities.stream()
                .forEach(e -> {
                    Store store = entityFactory.createStore(e);
                    stores.put(store.getId(), store);
                });
        return stores;
    }
}
