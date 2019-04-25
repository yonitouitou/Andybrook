package com.andybrook.generator;

import com.andybrook.model.BarCode;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.model.stock.ProductItem;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public final class OrderItemGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static OrderItem generateOrderItem(ProductItem productItem) {
        return new OrderItem(productItem);
    }

    public static ProductItemInfo generateOrderItemInfo(Product product, int requestedQuantity) {
        return new ProductItemInfo(product.getId(), requestedQuantity);
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
