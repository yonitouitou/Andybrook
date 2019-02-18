package com.andybrook.generator;

import com.andybrook.enums.ProductType;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class StockReportGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static final StockReport generateBasicStockReport() {
        Map<Long, StockItem<? extends Product>> items = new HashMap<>();

        long randomLong = RANDOM.nextLong();
        for (int i = 0; i < 10; i++) {
            Glasses glasses = new Glasses(randomLong, "MyGlasses_" + randomLong, RANDOM.nextInt(10, 500));
            StockItem<Glasses> item = new StockItem(System.nanoTime(), glasses, ProductType.GLASSES, RANDOM.nextInt(1, 150));
            items.put(item.getId(), item);
        }
        return new StockReport(System.currentTimeMillis(), "MyReport", CustomerGenerator.generateCustomer(), items);
    }
}
