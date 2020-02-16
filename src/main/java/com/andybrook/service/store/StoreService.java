package com.andybrook.service.store;

import com.andybrook.dao.store.IStoreDao;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.customer.Store;
import com.andybrook.service.owner.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class StoreService implements IStoreService {

    @Autowired
    private IStoreDao dao;
    @Autowired
    private IOwnerService ownerService;

    @Override
    public void newStore(Store store) {
        if (shouldCreateOwner(store)) {
            ownerService.newOwner(store.getOwner());
        }
        dao.save(store);
    }

    @Override
    public void update(Store store) throws StoreNotFound {
        boolean exists = exists(store.getId());
        if (exists) {
            dao.save(store);
        } else {
            throw new StoreNotFound(store.getId());
        }
    }

    @Override
    public Map<Long, Store> getStoresOfOwner(long ownerId) {
        return dao.getStoresOfOwner(ownerId);
    }

    @Override
    public Store getById(long id) throws StoreNotFound {
        Store store;
        Optional<Store> storeOpt = dao.find(id);
        if (storeOpt.isPresent()) {
            store = storeOpt.get();
        } else {
            throw new StoreNotFound(id);
        }
        return store;
    }

    @Override
    public List<Store> getByNameContaining(String name) {
        return dao.getByNameContaining(name);
    }

    @Override
    public List<Store> getAll(OptionalInt limitOpt) {
        return dao.getAll(limitOpt);
    }

    private boolean shouldCreateOwner(Store store) {
        return store.getOwner().getId() == null;
    }

    private boolean exists(long storeId) {
        return dao.exists(storeId);
    }
}
