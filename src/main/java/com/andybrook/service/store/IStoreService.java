package com.andybrook.service.store;

import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.customer.Store;

import java.util.Map;

public interface IStoreService {

    Store newStore(Store store);

    Store getById(long id) throws StoreNotFound;

    Map<Long, Store> getStoresOfOwner(long ownerId);
}
