package com.andybrook.dao.store;

import com.andybrook.model.customer.Store;

import java.util.Optional;

public interface IStoreDao {

    Store update(Store store);

    Optional<Store> find(long id);

    Store get(long id);
}
