package com.andybrook.model.api;

import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;

import java.util.List;

public class AggregatedOrderItem {

    private final int quantity;
    private final double ttlPrice;
    private final long lastModifiedDatetime;
    private final Product product;
    private final List<OrderItem> orderItems;

    public AggregatedOrderItem(List<OrderItem> orderItems, Product product, double ttlPrice) {
        this.orderItems = orderItems;
        this.quantity = orderItems.size();
        this.product = product;
        this.ttlPrice = ttlPrice;
        this.lastModifiedDatetime = findLastModifiedDatetime();
    }

    public long findLastModifiedDatetime() {
        return orderItems.stream()
                .map(OrderItem::getLastModifiedDatetime)
                .sorted()
                .findFirst()
                .get();
    }

    public int getQuantity() {
        return quantity;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTtlPrice() {
        return ttlPrice;
    }

    public long getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "AggregatedOrderItem{" +
                "quantity=" + quantity +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                ", orderItems=" + orderItems +
                '}';
    }
}
