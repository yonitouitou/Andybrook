package com.andybrook.model.order;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;

import java.time.LocalDateTime;
import java.util.Objects;

public final class OrderItem {

    protected Long id;
    protected Product product;
    protected BarCode barCode;
    protected LocalDateTime createdDatetime;
    protected LocalDateTime lastModifiedDatetime;

    public OrderItem(Long id, Product product) {
        this.id = id;
        this.product = product;
        this.barCode = null;
    }

    public OrderItem(Product product) {
        this.id = null;
        this.product = product;
        this.barCode = null;
    }

    public boolean exist() {
        return id != null;
    }

    public double getProductPrice() {
        return product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BarCode getBarCode() {
        return barCode;
    }

    public void setBarCode(BarCode barCode) {
        this.barCode = barCode;
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
                ", product=" + product +
                ", barCode=" + barCode +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                '}';
    }
}
