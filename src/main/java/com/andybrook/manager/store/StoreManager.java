package com.andybrook.manager.store;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.customer.Store;
import com.andybrook.service.store.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreManager implements IStoreManager {

    @Autowired
    private IStoreService storeService;

    @Override
    public Store newStore(Store store) {
        return storeService.newStore(store);
    }

    @Override
    public Store update(Store store) {
        return storeService.update(store);
    }

    @Override
    public Store getById(long id) throws StoreNotFound {
        return storeService.getById(id);
    }
}
