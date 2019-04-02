package com.andybrook.model.product;

import com.andybrook.model.BarCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Product {

    protected Long id;
    protected String name;
    protected double price;
    protected int quantity;
    protected Map<String, BarCode> barCodes;

    private Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.barCodes = new HashMap<>();
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.barCodes = new HashMap<>();
    }

    public void addBarCode(BarCode barCode) {
        barCodes.put(barCode.getId(), barCode);
        quantity++;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<String, BarCode> getBarCodes() {
        return new HashMap<>(barCodes);
    }

    public void setBarCodes(Map<String, BarCode> barCodes) {
        this.barCodes = barCodes;
        quantity = barCodes.size();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Glasses{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
