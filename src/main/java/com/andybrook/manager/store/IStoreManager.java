package com.andybrook.manager.store;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.customer.Store;
import com.andybrook.model.request.customer.AddStoreRequest;

import java.util.List;
import java.util.OptionalInt;

public interface IStoreManager {

    Store newStore(AddStoreRequest req);

    void update(Store store);

    List<Store> getAll(OptionalInt limit);

    Store getById(long id) throws StoreNotFound;

    List<Store> getByNameContaining(String name);
}
