package com.andybrook.service.store;

import com.andybrook.dao.store.IStoreDao;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.customer.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class StoreService implements IStoreService {

    @Autowired
    private IStoreDao dao;

    @Override
    public Store newStore(Store store) {
        return dao.update(store);
    }

    @Override
    public Store update(Store store) throws StoreNotFound {
        Store updated;
        boolean exists = exists(store.getId());
        if (exists) {
            updated = dao.update(store);
        } else {
            throw new StoreNotFound(store.getId());
        }
        return updated;
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

    private boolean exists(long storeId) {
        return dao.exists(storeId);
    }
}
