package com.andybrook.generator;

import com.andybrook.model.BarCode;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
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

    public static OrderItemInfo generateOrderItemInfo(Product product, int orderItemQuantity) {
        OrderItemInfo info = new OrderItemInfo(product.getId(), orderItemQuantity);
        Map<String, BarCode> barCodes = product.getBarCodes();
        if (! barCodes.isEmpty()) {
            info.setBarCodeId(getRandomBarCode(barCodes.values()).getId());
        }
        return info;
    }


    public static OrderItemInfo generateOrderItemInfo(Product product) {
        return generateOrderItemInfo(product, RANDOM.nextInt(0, product.getQuantityCreated()));
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
