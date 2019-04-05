package com.andybrook.generator;

import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public final class OrderItemGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static OrderItem<? extends Product> generateOrderItem(Product product) {
        OrderItem<? extends Product> item = new OrderItem<>(product, RANDOM.nextInt(1, 100));
        Map<String, BarCode> barCodes = product.getBarCodes();
        if (! barCodes.isEmpty()) {
            item.setBarCode(getRandomBarCode(barCodes.values()));
        }
        return item;
    }

    public static OrderItemInfo generateOrderItemInfo(Product product) {
        OrderItemInfo info = new OrderItemInfo(product.getId(), RANDOM.nextInt(1, product.getQuantity()));
        Map<String, BarCode> barCodes = product.getBarCodes();
        if (! barCodes.isEmpty()) {
            info.setBarCodeId(getRandomBarCode(barCodes.values()).getId());
        }
        return info;
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
