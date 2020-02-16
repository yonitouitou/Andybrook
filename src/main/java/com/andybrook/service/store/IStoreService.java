package com.andybrook.service.store;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.customer.Store;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public interface IStoreService {

    void newStore(Store store);

    void update(Store store) throws StoreNotFound;

    Store getById(long id) throws StoreNotFound;

    Map<Long, Store> getStoresOfOwner(long ownerId);

    List<Store> getByNameContaining(String name);

    List<Store> getAll(OptionalInt limitOpt);
}
