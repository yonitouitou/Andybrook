package com.andybrook.dao.order;

import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.enums.OrderStatus;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderEntity {

    private final long id;
    private final String name;
    private final String comment;
    private final long storeId;
    private final Collection<OrderItem> orderItems;
    private final long createdDateTime;
    private final long lastModifiedDateTime;
    private final long closeDateTime;
    private final OrderStatus status;

    private OrderEntity(long id, String name, String comment, long storeId, Collection<OrderItem> orderItems,
                        long createdDateTime, long lastModifiedDateTime, long closeDateTime, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.storeId = storeId;
        this.orderItems = orderItems;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.closeDateTime = closeDateTime;
        this.status = status;
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

    public long getStoreId() {
        return storeId;
    }

    public Collection<OrderItem> getItems() {
        return orderItems;
    }

    public long getCreatedDateTime() {
        return createdDateTime;
    }

    public long getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public long getCloseDateTime() {
        return closeDateTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    static class Converter implements IEntityConverter<Order, OrderEntity> {

        @Override
        public Order toModel(OrderEntity entity) {
            Order order = new Order(entity.getId(), entity.name, entity.getStoreId());
            order.setComment(entity.getComment());
            order.setStatus(order.getStatus());
            order.setCreatedDateTime(order.getCreatedDateTime());
            order.setLastModifiedDateTime(order.getLastModifiedDateTime());
            order.setCloseDateTime(order.getCloseDateTime());
            Map<String, OrderItem> orderItems = entity.getItems()
                    .stream()
                    .collect(Collectors.toConcurrentMap(OrderItem::getId, Function.identity()));
            order.setOrderItems(orderItems);
            return order;
        }

        @Override
        public OrderEntity toEntity(Order order) {
            return new OrderEntity(
                    order.getId(),
                    order.getName(),
                    order.getComment(),
                    order.getStoreId(),
                    order.getOrderItems(),
                    order.getCreatedDateTime(),
                    order.getLastModifiedDateTime(),
                    order.getCloseDateTime(),
                    order.getStatus()
            );
        }
    }
}
