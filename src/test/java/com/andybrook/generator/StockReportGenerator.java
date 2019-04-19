package com.andybrook.generator;

import com.andybrook.model.order.Order;

import java.util.concurrent.ThreadLocalRandom;

public class StockReportGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static final Order generateBasicStockReport() {
        return new Order(System.currentTimeMillis(), "MyReport", CustomerGenerator.generateCustomer());
    }
}
