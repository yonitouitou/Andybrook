package com.andybrook.model.order;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;

import java.time.LocalDateTime;
import java.util.Objects;

public final class OrderItem {

    protected Long id;
    protected ProductItem productItem;
    protected LocalDateTime createdDatetime;
    protected LocalDateTime lastModifiedDatetime;

    public OrderItem(Long id, ProductItem productItem) {
        this.id = id;
        this.productItem = productItem;
    }

    public OrderItem(ProductItem productItem) {
        this.id = null;
        this.productItem = productItem;
    }

    public boolean exist() {
        return id != null;
    }

    public double getProductPrice() {
        return productItem.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getProductId() {
        return productItem.getProductId();
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
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
                ", productItem=" + productItem +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                '}';
    }
}
