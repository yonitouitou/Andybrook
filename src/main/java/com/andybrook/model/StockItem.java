package com.andybrook.model;

import com.andybrook.enums.ProductType;

public class StockItem<T extends Product> {

    protected Long id;
    protected T product;
    protected ProductType type;
    protected int quantity;

    public StockItem(Long id, T product, ProductType productType, int quantity) {
        this.id = id;
        this.product = product;
        this.type = productType;
        this.quantity = quantity;
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
}
