package com.andybrook.model.product;

import com.andybrook.model.BarCode;

import java.util.Set;

public abstract class Product {

    protected Long id;
    protected String name;
    protected double price;
    protected Set<BarCode> barCodes;

    private Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addBarCode(BarCode barCode) {
        barCodes.add(barCode);
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

    public Set<BarCode> getBarCodes() {
        return barCodes;
    }

    public void setBarCodes(Set<BarCode> barCodes) {
        this.barCodes = barCodes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Glasses{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
