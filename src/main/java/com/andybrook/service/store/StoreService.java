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
    private IStoreDao storeDao;

    @Override
    public Store newStore(Store store) {
        return storeDao.update(store);
    }

    @Override
    public Map<Long, Store> getStoresOfOwner(long ownerId) {
        return storeDao.getStoresOfOwner(ownerId);
    }

    @Override
    public Store getById(long id) throws StoreNotFound {
        Store store;
        Optional<Store> storeOpt = storeDao.find(id);
        if (storeOpt.isPresent()) {
            store = storeOpt.get();
        } else {
            throw new StoreNotFound(id);
        }
        return store;
    }
}
