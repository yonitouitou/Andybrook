package com.andybrook.generator;

import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;

import java.util.concurrent.ThreadLocalRandom;

public final class StockItemGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static OrderItem<? extends Product> generateOrderItem(Product product, BarCode barCode) {
        OrderItem<? extends Product> item = new OrderItem<>(product, ProductType.GLASSES, RANDOM.nextInt(1, 100));
        item.setBarCode(barCode);
        return item;
    }
}
