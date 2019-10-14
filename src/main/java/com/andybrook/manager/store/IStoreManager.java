package com.andybrook.manager.store;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.customer.Store;

public interface IStoreManager {

    Store newStore(Store store);

    Store update(Store store);

    Store getById(long id) throws StoreNotFound;
}
