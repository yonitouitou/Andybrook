package com.andybrook.generator;

import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;

public final class StoreGenerator {

    public static final Store generateStore() {
        long now = System.nanoTime();
        Owner owner = new Owner("John_" + now, "Durant_" + now, "john.durant_" + now + "@gmail.com");
        return new Store("MyStore_" + now, "myStore@gmail.com", "15 avenue du 8 mai 1945", owner);
    }
}
