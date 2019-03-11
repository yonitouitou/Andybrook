package com.andybrook.model;

import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Product;
import com.andybrook.util.IdGenerator;

public final class StockItem<T extends Product> {

    protected Long id;
    protected T product;
    protected ProductType type;
    protected int quantity;
    protected BarCode barCode;

    public StockItem(Long id, T product, ProductType type, int quantity, BarCode barCode) {
        this.id = id;
        this.product = product;
        this.type = type;
        this.quantity = quantity;
        this.barCode = barCode;
    }

    public StockItem(Long id, T product, ProductType productType, int quantity) {
        this.id = id != null ? id : IdGenerator.generateId();
        this.product = product;
        this.type = productType;
        this.quantity = quantity;
        this.barCode = null;
    }

    public StockItem(T product, ProductType productType, int quantity) {
        this(IdGenerator.generateId(), product, productType, quantity);
    }

    public boolean exist() {
        return id != null;
    }

    public double getTotalPrice() {
        return quantity * product.getPrice();
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

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", product=" + product +
                ", type=" + type +
                ", quantity=" + quantity +
                ", barCode=" + barCode +
                '}';
    }
}
