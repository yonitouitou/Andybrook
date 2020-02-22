package com.andybrook.model.api;

import com.andybrook.enums.OrderStatus;
import com.andybrook.model.customer.Store;

public class AggregatedOrderInfo {

    private final long id;
    private final String name;
    private final String comment;
    private final Store store;
    private final OrderStatus status;
    private final long createdDatetime;
    private final long lastModifiedDatetime;
    private final long closeDatetime;
    private final int orderItemSize;
    private final int productSize;
    private final double totalPrice;

    public AggregatedOrderInfo(long id, String name, String comment, Store store, OrderStatus status,
                               long createdDatetime, long lastModifiedDatetime, long closeDatetime,
                               int orderItemSize, int productSize, double totalPrice) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.store = store;
        this.status = status;
        this.createdDatetime = createdDatetime;
        this.lastModifiedDatetime = lastModifiedDatetime;
        this.closeDatetime = closeDatetime;
        this.orderItemSize = orderItemSize;
        this.productSize = productSize;
        this.totalPrice = totalPrice;
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public Store getStore() {
        return store;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public long getCreatedDatetime() {
        return createdDatetime;
    }

    public long getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public long getCloseDatetime() {
        return closeDatetime;
    }

    @Override
    public String toString() {
        return "AggregatedOrderInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", store=" + store +
                ", status=" + status +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                ", closeDatetime=" + closeDatetime +
                ", orderItemSize=" + orderItemSize +
                ", productSize=" + productSize +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
