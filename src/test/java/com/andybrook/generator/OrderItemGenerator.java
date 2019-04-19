package com.andybrook.generator;

import com.andybrook.model.BarCode;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.OrderItemInfo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public final class OrderItemGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static OrderItem generateOrderItem(Product product) {
        OrderItem item = new OrderItem(product);
        Map<String, BarCode> barCodes = product.getBarCodes();
        if (! barCodes.isEmpty()) {
            item.setBarCode(getRandomBarCode(barCodes.values()));
        }
        return item;
    }

    public static OrderItemInfo generateOrderItemInfo(Product product) {
        OrderItemInfo info = new OrderItemInfo(null, product.getId());
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
