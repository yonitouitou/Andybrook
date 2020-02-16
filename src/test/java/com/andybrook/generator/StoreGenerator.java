package com.andybrook.generator;

import com.andybrook.model.common.Address;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.util.clock.Clock;

public final class StoreGenerator {

    public static Store generateStore() {
        long now = Clock.nanos();
        Owner owner = OwnerGenerator.generateOwner();
        Address address = new Address("15", "avenue du 8 mai 1945", "Paris", "France", 75003);
        return new Store("MyStore_" + now, "myStore@gmail.com", "01.39.90.45.32", address, owner);
    }

    public static Store generateStore(Owner owner) {
        long now = Clock.nanos();
        Address address = new Address("15", "avenue du 8 mai 1945", "Paris", "France", 75003);
        return new Store("MyStore_" + now, "myStore@gmail.com", "01.39.90.45.32", address, owner);
    }
}
