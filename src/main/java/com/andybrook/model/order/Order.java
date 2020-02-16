package com.andybrook.model.order;

import com.andybrook.enums.OrderStatus;
import com.andybrook.exception.OrderClosed;
import com.andybrook.util.IdGenerator;
import com.andybrook.util.clock.Clock;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(indexName = "orders")
public class Order {

    private Long id;
    private String name;
    private String comment;
    private final long storeId;
    private Map<String, OrderItem> orderItems;
    private long createdDateTime;
    private long lastModifiedDateTime;
    private long closeDateTime;
    private OrderStatus status;

    private Order() {
        storeId = 0L;
    }

    public Order(Long id, String name, long storeId) {
        this.id = id;
        this.name = name;
        this.storeId = storeId;
        this.orderItems = new HashMap<>();
        this.status = OrderStatus.OPEN;
        this.createdDateTime = Clock.millis();
        this.lastModifiedDateTime = createdDateTime;
        this.comment = "";
    }

    public Order(String name, long storeId) {
        this(IdGenerator.generateId(), name, storeId);
    }

    public void addOrderItem(OrderItem item) {
        orderItems.put(item.getId(), item);
    }

    public void addOrderItems(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            addOrderItem(orderItem);
        }
    }

    public OrderItem deleteItem(String orderItemId) {
        return orderItems.remove(orderItemId);
    }

    public void close() throws OrderClosed {
        if (isClosed()) {
            throw new OrderClosed(id);
        }
        status = OrderStatus.CLOSED;
        long now = Clock.millis();
        closeDateTime = now;
        lastModifiedDateTime = now;
    }

    public long getStoreId() {
        return storeId;
    }

    public long getCloseDateTime() {
        return closeDateTime;
    }

    public OrderItem getItem(String orderItemId) {
        return orderItems.get(orderItemId);
    }

    public boolean hasItem(String orderItemId) {
        return getItem(orderItemId) != null;
    }

    public boolean isOpen() {
        return status != OrderStatus.CLOSED;
    }

    public boolean isClosed() {
        return status == OrderStatus.CLOSED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setOrderItems(Map<String, OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems.values();
    }

    public long getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(long createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public long getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(long lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setCloseDateTime(long closeDateTime) {
        this.closeDateTime = closeDateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", storeId='").append(storeId).append('\'');
        sb.append(", items=").append(orderItems);
        sb.append(", createdDateTime=").append(createdDateTime);
        sb.append(", closeDateTime=").append(closeDateTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
