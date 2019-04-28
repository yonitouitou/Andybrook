package com.andybrook.model.api.rest;

import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;

import java.time.LocalDateTime;
import java.util.List;

public class AggregatedOrderItem {

    private final int quantity;
    private final double ttlPrice;
    private final LocalDateTime lastModifiedDatetime;
    private final Product product;
    private final List<OrderItem> orderItems;

    public AggregatedOrderItem(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        this.quantity = orderItems.size();
        this.product = quantity > 0 ? orderItems.get(0).getProductItem().getProduct() : null;
        this.ttlPrice = calculateTotalPrice();
        this.lastModifiedDatetime = findLastModifiedDatetime();
    }

    private double calculateTotalPrice() {
        ProductItem productItem = orderItems.get(0).getProductItem();
        return getQuantity() * productItem.getPrice();
    }

    public LocalDateTime findLastModifiedDatetime() {
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

    public LocalDateTime getLastModifiedDatetime() {
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
