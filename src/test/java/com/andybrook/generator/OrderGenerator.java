package com.andybrook.generator;

import com.andybrook.model.customer.Store;
import com.andybrook.model.order.Order;

public class OrderGenerator {

    public static Order generateBasicOrder() {
        Store store = StoreGenerator.generateStore();
        return new Order(System.currentTimeMillis(), "MyReport", store.getId());
    }

    public static Order generateOrder(long storeId) {
        return new Order(System.currentTimeMillis(), "MyReport", storeId);
    }
}
