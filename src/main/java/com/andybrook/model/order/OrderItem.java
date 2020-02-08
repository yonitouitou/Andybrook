package com.andybrook.model.order;

import com.andybrook.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.Objects;

public final class OrderItem {

    protected Long id;
    protected final long orderId;
    protected final long productItemId;
    protected final LocalDateTime createdDatetime;
    protected LocalDateTime lastModifiedDatetime;

    public OrderItem(long orderId, long productItemId) {
        this.id = IdGenerator.generateId();
        this.orderId = orderId;
        this.productItemId = productItemId;
        this.createdDatetime = LocalDateTime.now();
    }

    public OrderItem(long id, long orderId, long productItemId) {
        this.id = id;
        this.orderId = orderId;
        this.productItemId = productItemId;
        this.createdDatetime = LocalDateTime.now();
    }

    public boolean exist() {
        return id != null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getProductItemId() {
        return productItemId;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public LocalDateTime getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(LocalDateTime lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id.equals(orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", productItemId=" + productItemId +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                '}';
    }
}
