package com.andybrook.model.api;

import com.andybrook.enums.OrderStatus;
import com.andybrook.model.customer.Store;

import java.time.LocalDateTime;
import java.util.List;

public final class AggregatedOrder {

    private final long id;
    private final String name;
    private final String comment;
    private final Store store;
    private final OrderStatus status;
    private final LocalDateTime createdDatetime;
    private final LocalDateTime lastModifiedDatetime;
    private final LocalDateTime closeDatetime;
    private final AggregatedOrderInfo aggregatedOrderInfo;
    private final List<AggregatedOrderItem> aggregatedOrderItems;

    public AggregatedOrder(long id, String name, Store store, OrderStatus status,
                           String comment, LocalDateTime createdDatetime, LocalDateTime lastModifiedDatetime,
                           LocalDateTime closeDatetime, AggregatedOrderInfo aggregatedOrderInfo,
                           List<AggregatedOrderItem> aggregatedOrderItems) {
        this.id = id;
        this.name = name;
        this.store = store;
        this.comment = comment;
        this.status = status;
        this.createdDatetime = createdDatetime;
        this.lastModifiedDatetime = lastModifiedDatetime;
        this.closeDatetime = closeDatetime;
        this.aggregatedOrderInfo = aggregatedOrderInfo;
        this.aggregatedOrderItems = aggregatedOrderItems;
    }

    public long getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }

    public String getName() {
        return name;
    }

    public OrderStatus getStatus() {
        return status;
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

    public AggregatedOrderInfo getAggregatedOrderInfo() {
        return aggregatedOrderInfo;
    }

    public List<AggregatedOrderItem> getAggregatedOrderItems() {
        return aggregatedOrderItems;
    }

    public String getComment() {
        return comment;
    }
}
