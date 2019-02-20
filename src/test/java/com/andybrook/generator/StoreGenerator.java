package com.andybrook.generator;

import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;

public final class StoreGenerator {

    public static final Store generateStore() {
       Owner owner = new Owner(1L, "John", "Durant", "john.durant@gmail.com");
       return new Store(1L, "MyStore", "myStore@gmail.com", "15 avenue du 8 mai 1945", owner);
    }
}