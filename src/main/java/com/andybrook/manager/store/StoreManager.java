package com.andybrook.manager.store;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddStoreRequest;
import com.andybrook.service.store.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalInt;

@Service
public class StoreManager implements IStoreManager {

    @Autowired
    private IStoreService storeService;

    @Override
    public Store newStore(AddStoreRequest req) {
        Owner owner = new Owner(req.getOwnerCompagnyName(), req.getOwnerFirstName(),
                req.getOwnerLastName(), req.getOwnerEmail());
        Store store = new Store(req.getStoreName(), req.getStoreEmail(), req.getStorePhone(),
                req.getStoreAddress(), owner);
        storeService.newStore(store);
        return store;
    }

    @Override
    public void update(Store store) {
        storeService.update(store);
    }

    @Override
    public Store getById(long id) throws StoreNotFound {
        return storeService.getById(id);
    }

    @Override
    public List<Store> getAll(OptionalInt limit) {
        return storeService.getAll(limit);
    }

    @Override
    public List<Store> getByNameContaining(String name) {
        return storeService.getByNameContaining(name);
    }
}
