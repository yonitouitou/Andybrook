package com.andybrook.generator;

import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public final class StockItemGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static OrderItem<? extends Product> generateOrderItem(Product product) {
        OrderItem<? extends Product> item = new OrderItem<>(product, ProductType.GLASSES, RANDOM.nextInt(1, 100));
        Map<String, BarCode> barCodes = product.getBarCodes();
        if (! barCodes.isEmpty()) {
            item.setBarCode(getRandomBarCode(barCodes.values()));
        }
        return item;
    }

    private static BarCode getRandomBarCode(Collection<BarCode> barCodes) {
        int nbOfBarCodes = barCodes.size();
        int index = RANDOM.nextInt(0, nbOfBarCodes);
        Iterator<BarCode> iterator = barCodes.iterator();
        int i = 0;
        while (i < index) {
            iterator.next();
            i++;
        }
        return iterator.next();
    }
}
