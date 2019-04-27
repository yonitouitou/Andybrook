package com.andybrook.model.api.rest;

import com.andybrook.enums.OrderStatus;
import com.andybrook.model.customer.Store;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.stock.ProductItem;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class AggregatedOrder {

    private final long id;
    private final long storeId;
    private final String name;
    private final String storeName;
    private final OrderStatus status;
    private final int orderItemSize;
    private final int productSize;
    private final double totalPrice;
    private final LocalDateTime createdDatetime;
    private final LocalDateTime lastModifiedDatetime;
    private final LocalDateTime closeDatetime;

    public AggregatedOrder(long id, long storeId, String name, String storeName, OrderStatus status,
                           int orderItemSize, int productSize, double totalPrice, LocalDateTime createdDatetime,
                           LocalDateTime lastModifiedDatetime, LocalDateTime closeDatetime) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.storeName = storeName;
        this.status = status;
        this.orderItemSize = orderItemSize;
        this.productSize = productSize;
        this.totalPrice = totalPrice;
        this.createdDatetime = createdDatetime;
        this.lastModifiedDatetime = lastModifiedDatetime;
        this.closeDatetime = closeDatetime;
    }

    public static Stream<AggregatedOrder> toAggregatedOrders(Stream<Order> ordersStream) {
        return ordersStream.map(AggregatedOrder::toAggregatedOrder);
    }

    public static AggregatedOrder toAggregatedOrder(Order order) {
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

        Store store = order.getCustomer().getStore();
        return new AggregatedOrder(order.getId(), store.getId(), order.getName(), store.getName(), order.getStatus(),
                orderItemSize, productSize, ttlPrice, order.getCreatedDateTime(), order.getLastModifiedDateTime(),
                order.getCloseDateTime());
    }

    public long getId() {
        return id;
    }

    public long getStoreId() {
        return storeId;
    }

    public String getName() {
        return name;
    }

    public String getStoreName() {
        return storeName;
    }

    public OrderStatus getStatus() {
        return status;
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

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public LocalDateTime getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public LocalDateTime getCloseDatetime() {
        return closeDatetime;
    }

    @Override
    public String toString() {
        return "AggregatedOrder{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", name='" + name + '\'' +
                ", storeName='" + storeName + '\'' +
                ", status=" + status +
                ", orderItemSize=" + orderItemSize +
                ", productSize=" + productSize +
                ", totalPrice=" + totalPrice +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                ", closeDatetime=" + closeDatetime +
                '}';
    }
}
