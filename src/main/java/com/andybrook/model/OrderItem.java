package com.andybrook.model;

import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Product;
import com.andybrook.util.IdGenerator;

import java.time.LocalDateTime;

public final class OrderItem<T extends Product> {

    protected Long id;
    protected T product;
    protected ProductType type;
    protected int quantity;
    protected BarCode barCode;
    protected LocalDateTime createdDatetime;
    protected LocalDateTime lastModifiedDatetime;

    public OrderItem(Long id, T product, ProductType productType, int quantity) {
        this.id = id;
        this.product = product;
        this.type = productType;
        this.quantity = quantity;
        this.barCode = null;
    }

    public OrderItem(T product, ProductType productType, int quantity) {
        this.id = null;
        this.product = product;
        this.type = productType;
        this.quantity = quantity;
        this.barCode = null;
    }

    public void update(OrderItem<T> orderItem) {
        this.product = orderItem.product;
        this.type = orderItem.type;
        this.quantity = orderItem.quantity;
        this.barCode = orderItem.barCode;
    }

    public void setIdIfNeeded() {
        if (id == null) {
            id = IdGenerator.generateId();
        }
    }

    public boolean exist() {
        return id != null;
    }

    public void incrementQuantity() {
        quantity = quantity + 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return quantity * product.getPrice();
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
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
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", type=" + type +
                ", quantity=" + quantity +
                ", barCode=" + barCode +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                '}';
    }
}
