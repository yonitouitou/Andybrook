package com.andybrook.model.api;

import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.stock.ProductItem;

import java.util.stream.Stream;

public class AggregatedOrderInfo {

    private final int orderItemSize;
    private final int productSize;
    private final double totalPrice;

    private AggregatedOrderInfo(int orderItemSize, int productSize, double totalPrice) {
        this.orderItemSize = orderItemSize;
        this.productSize = productSize;
        this.totalPrice = totalPrice;
    }

    public static Stream<AggregatedOrderInfo> toAggregatedOrdersInfo(Stream<Order> ordersStream) {
        return ordersStream.map(AggregatedOrderInfo::toAggregatedOrderInfo);
    }

    public static AggregatedOrderInfo toAggregatedOrderInfo(Order order) {
        int orderItemSize = order.getItems().size();
        int productSize = (int) order.getItems()
                .stream()
                .map(OrderItem::getProductItem)
                .map(ProductItem::getProductId)
                .distinct()
                .count();
        double ttlPrice = order.getItems()
                .stream()
                .map(OrderItem::getProductItem)
                .mapToDouble(ProductItem::getPrice)
                .sum();
        return new AggregatedOrderInfo(orderItemSize, productSize, ttlPrice);
    }

    public int getOrderItemSize() {
        return orderItemSize;
    }

    public int getProductSize() {
        return productSize;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "AggregatedOrderInfo{" +
                "orderItemSize=" + orderItemSize +
                ", productSize=" + productSize +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
