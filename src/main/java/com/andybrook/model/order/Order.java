package com.andybrook.model.order;

import com.andybrook.enums.OrderStatus;
import com.andybrook.exception.OrderClosed;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.customer.Store;

import java.time.LocalDateTime;
import java.util.*;

import static com.andybrook.util.PerfConst.PRODUCT_SIZE_1024;

public class Order {

    private Long id;
    private String name;
    private String comment;
    private final Store store;
    private Map<Long, OrderItem> items;
    private Map<Long, List<OrderItem>> itemsMapByProductId;
    private LocalDateTime createdDateTime;
    private LocalDateTime lastModifiedDateTime;
    private LocalDateTime closeDateTime;
    private OrderStatus status;

    public Order(Long id, String name, Store store) {
        this.id = id;
        this.name = name;
        this.store = store;
        this.items = new HashMap<>();
        this.itemsMapByProductId = new HashMap<>(PRODUCT_SIZE_1024);
        this.status = OrderStatus.OPEN;
        this.comment = "";
    }

    public void addOrderItem(OrderItem item) {
        synchronized (this) {
            items.put(item.getId(), item);
            List<OrderItem> orderItems = itemsMapByProductId.computeIfAbsent(item.getProductItem().getId(), l -> new LinkedList<>());
            orderItems.add(item);
        }
    }

    public void addOrderItems(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            addOrderItem(orderItem);
        }
    }

    public OrderItem deleteItem(long orderItemId) {
        OrderItem orderItemDeleted;
        synchronized (this) {
            orderItemDeleted = items.remove(orderItemId);
        }
        return orderItemDeleted;
    }

    public void close() throws OrderClosed {
        if (isClosed()) {
            throw new OrderClosed(id);
        }
        status = OrderStatus.CLOSED;
        closeDateTime = LocalDateTime.now();
    }

    public AggregatedOrder aggregate() {
        return AggregatedOrder.toAggregatedOrder(this);
    }

    public int getTotalQuantity() {
        return items.values().size();
    }

    public long getDistinctProductQty() {
        return items.values()
                .stream()
                .map(OrderItem::getProductId)
                .distinct()
                .count();
    }

    public double getTotalAmount() {
        return items.values()
                .stream()
                .mapToDouble(OrderItem::getProductPrice)
                .sum();
    }

    public double calculateTotalPrice() {
        return items.values().stream()
                .mapToDouble(OrderItem::getProductPrice)
                .sum();
    }

    public List<OrderItem> getOrderItemsByProductId(long productId) {
        return itemsMapByProductId.get(productId);
    }

    public int calculateQuantityOfProduct(long productId) {
        List<OrderItem> orderItems = itemsMapByProductId.get(productId);
        return orderItems != null ? orderItems.size() : 0;
    }

    public double calculateTotalPriceByProduct(long productId) {
        List<OrderItem> orderItems = itemsMapByProductId.get(productId);
        return orderItems == null
                ? 0d
                : orderItems.stream()
                    .mapToDouble(OrderItem::getProductPrice)
                    .sum();
    }

    public Store getStore() {
        return store;
    }

    public LocalDateTime getCloseDateTime() {
        return closeDateTime;
    }

    public OrderItem getItem(long orderItemId) {
        return items.get(orderItemId);
    }

    public boolean hasItem(long orderItemId) {
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

    public void setItems(Map<Long, OrderItem> items) {
        this.items = items;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Collection<OrderItem> getItems() {
        return items.values();
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
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
        sb.append(", store='").append(store).append('\'');
        sb.append(", items=").append(items);
        sb.append(", createdDateTime=").append(createdDateTime);
        sb.append(", closeDateTime=").append(closeDateTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
