package com.andybrook.model.order;

import com.andybrook.util.IdGenerator;
import com.andybrook.util.clock.Clock;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Objects;

@Document(indexName = "order_items")
public final class OrderItem {

    protected final String id;
    protected final long orderId;
    protected final long productItemId;
    protected final long createdDatetime;
    protected long lastModifiedDatetime;

    private OrderItem() {
        this.id = null;
        this.orderId = 0L;
        this.productItemId = 0L;
        this.createdDatetime = 0L;
    }

    public OrderItem(long orderId, long productItemId) {
        this.id = IdGenerator.generateAlfaNumericId();
        this.orderId = orderId;
        this.productItemId = productItemId;
        this.createdDatetime = Clock.millis();
        this.lastModifiedDatetime = createdDatetime;
    }

    public String getId() {
        return id;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getProductItemId() {
        return productItemId;
    }

    public long getCreatedDatetime() {
        return createdDatetime;
    }

    public long getLastModifiedDatetime() {
        return lastModifiedDatetime;
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
