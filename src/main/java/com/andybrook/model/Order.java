package com.andybrook.model;

import com.andybrook.enums.OrderStatus;
import com.andybrook.exception.OrderClosed;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;

import java.time.LocalDateTime;
import java.util.*;

public class Order {

    protected Long id;
    protected String name;
    protected String comment;
    protected final Customer customer;
    protected Map<Long, OrderItem<? extends Product>> items;
    protected Map<Long, Long> itemIdMapByProductId;
    protected LocalDateTime createdDateTime;
    protected LocalDateTime closeDateTime;
    protected OrderStatus status;

    public Order(Long id, String name, Customer customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.items = new HashMap<>();
        this.itemIdMapByProductId = new HashMap<>();
        this.status = OrderStatus.OPEN;
        this.comment = "";
    }

    public void addItem(OrderItem<? extends Product> item) {
        synchronized (this) {
            itemIdMapByProductId.put(item.getProduct().getId(), item.getId());
            items.put(item.getId(), item);
        }
    }

    public OrderItem<? extends Product> deleteItem(long orderItemId) {
        OrderItem<? extends Product> orderItemDeleted;
        synchronized (this) {
            orderItemDeleted = items.remove(orderItemId);
            itemIdMapByProductId.remove(orderItemDeleted.getProduct().getId());
        }
        return orderItemDeleted;
    }

    public OrderItem<? extends Product> findLastItemAdded() {
        return items.values()
                .stream()
                .sorted(Comparator.comparing(OrderItem::getCreatedDatetime))
                .reduce((first, second) -> second).orElse(null);
    }

    public void close() throws OrderClosed {
        if (isClosed()) {
            throw new OrderClosed(id);
        }
        status = OrderStatus.CLOSED;
        closeDateTime = LocalDateTime.now();
    }

    public int getTotalQuantity() {
        return items.values().stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();
    }

    public double getTotalPrice() {
        return items.values().stream()
                .mapToDouble(OrderItem::calculateTotalPrice)
                .sum();
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getCloseDateTime() {
        return closeDateTime;
    }

    public OrderItem<? extends Product> getItem(long orderItemId) {
        return items.get(orderItemId);
    }

    public boolean hasItem(long orderItemId) {
        return items.containsKey(orderItemId);
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

    public void setItems(Map<Long, OrderItem<? extends Product>> items) {
        this.items = items;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Collection<OrderItem<? extends Product>> getItems() {
        return items.values();
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setCloseDateTime(LocalDateTime closeDateTime) {
        this.closeDateTime = closeDateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", owner='").append(customer).append('\'');
        sb.append(", items=").append(items);
        sb.append(", createdDateTime=").append(createdDateTime);
        sb.append(", closeDateTime=").append(closeDateTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
