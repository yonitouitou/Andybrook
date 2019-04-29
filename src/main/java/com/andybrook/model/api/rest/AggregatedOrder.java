package com.andybrook.model.api.rest;

import com.andybrook.enums.OrderStatus;
import com.andybrook.model.customer.Store;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AggregatedOrder {

    private final long id;
    private final long storeId;
    private final String name;
    private final String storeName;
    private final String comment;
    private final OrderStatus status;
    private final LocalDateTime createdDatetime;
    private final LocalDateTime lastModifiedDatetime;
    private final LocalDateTime closeDatetime;
    private final AggregatedOrderInfo aggregatedOrderInfo;
    private final List<AggregatedOrderItem> aggregatedOrderItems;

    private AggregatedOrder(long id, long storeId, String name, String storeName, OrderStatus status,
                           String comment, LocalDateTime createdDatetime, LocalDateTime lastModifiedDatetime,
                           LocalDateTime closeDatetime, AggregatedOrderInfo aggregatedOrderInfo,
                           List<AggregatedOrderItem> aggregatedOrderItems) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.storeName = storeName;
        this.comment = comment;
        this.status = status;
        this.createdDatetime = createdDatetime;
        this.lastModifiedDatetime = lastModifiedDatetime;
        this.closeDatetime = closeDatetime;
        this.aggregatedOrderInfo = aggregatedOrderInfo;
        this.aggregatedOrderItems = aggregatedOrderItems;
    }

    public static Stream<AggregatedOrder> toAggregatedOrders(Stream<Order> orders) {
        return orders.map(AggregatedOrder::toAggregatedOrder);
    }

    public static AggregatedOrder toAggregatedOrder(Order order) {
        Map<Long, List<OrderItem>> orderItemByProductId = order.getItems()
                .stream()
                .collect(Collectors.groupingBy(OrderItem::getProductId));
        List<AggregatedOrderItem> aggregatedOrderItems = new LinkedList<>();
        orderItemByProductId.forEach((k, v) ->
            aggregatedOrderItems.add(new AggregatedOrderItem(v))
        );
        AggregatedOrderInfo info = AggregatedOrderInfo.toAggregatedOrderInfo(order);
        Store store = order.getCustomer().getStore();
        return new AggregatedOrder(order.getId(), store.getId(), order.getName(), store.getName(), order.getStatus(),
                order.getComment(), order.getCreatedDateTime(), order.getLastModifiedDateTime(),
                order.getCloseDateTime(), info, aggregatedOrderItems);
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
