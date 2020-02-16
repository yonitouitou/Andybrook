package com.andybrook.dao.store;

import com.andybrook.model.customer.Store;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

public interface IStoreDao {

    void save(Store store);

    Optional<Store> find(long id);

    Store get(long id);

    boolean exists(long id);

    List<Store> getByNameContaining(String name);

    List<Store> getAll(OptionalInt limitOpt);

    Map<Long, Store> getStoresOfOwner(long ownerId);
}
