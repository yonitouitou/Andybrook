package com.andybrook.util;

import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class OrderItemAggregatorUtil {

    public static final AggregatedOrderItem toAggregatedOrderItem(Order order, long productId) {
        List<OrderItem> orderItems = order.getOrderItemsByProductId(productId);
        return new AggregatedOrderItem(orderItems);
    }

    public static final List<AggregatedOrderItem> getAggregatedOrderItems(Order order) {
        Map<? extends Product, List<OrderItem>> orderItemsByProductId = order.getItems()
                .stream()
                .collect(Collectors.groupingBy(orderItem -> orderItem.getProductItem().getProduct()));
        return orderItemsByProductId.values()
                .stream()
                .map(AggregatedOrderItem::new)
                .collect(Collectors.toList());

    }
}
