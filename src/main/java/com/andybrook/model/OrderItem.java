package com.andybrook.model;

import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Product;

import java.time.LocalDateTime;

public final class OrderItem<T extends Product> {

    protected Long id;
    protected T product;
    protected int quantity;
    protected BarCode barCode;
    protected LocalDateTime createdDatetime;
    protected LocalDateTime lastModifiedDatetime;

    public OrderItem(Long id, T product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.barCode = null;
    }

    public OrderItem(T product, int quantity) {
        this.id = null;
        this.product = product;
        this.quantity = quantity;
        this.barCode = null;
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
                ", quantity=" + quantity +
                ", barCode=" + barCode +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                '}';
    }
}
