package com.andybrook.generator;

import com.andybrook.model.order.Order;

import java.util.concurrent.ThreadLocalRandom;

public class OrderGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static final Order generateBasicOrder() {
        return new Order(System.currentTimeMillis(), "MyReport", StoreGenerator.generateStore());
    }
}
