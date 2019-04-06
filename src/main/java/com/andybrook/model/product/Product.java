package com.andybrook.model.product;

import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Product {

    protected Long id;
    protected String name;
    protected double price;
    protected int quantityCreated;
    protected int quantityUsed;
    protected Map<String, BarCode> barCodes;

    public abstract ProductType getType();

    private Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityCreated = 0;
        this.quantityUsed = 0;
        this.barCodes = new HashMap<>();
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityCreated = 0;
        this.quantityUsed = 0;
        this.barCodes = new HashMap<>();
    }

    public void incrementQuantityCreated(int qtyToIncrement) {
        quantityCreated += qtyToIncrement;
    }

    public void decrementQuantityCreated(int qtyToDecrement) {
        quantityCreated -= qtyToDecrement;
    }

    public void incrementQuantityUsed(int qtyToIncrement) {
        quantityUsed += qtyToIncrement;
    }

    public void decrementQuantityUsed(int qtyToDecrement) {
        quantityUsed -= qtyToDecrement;
    }

    public void addBarCode(BarCode barCode) {
        barCodes.put(barCode.getId(), barCode);
        incrementQuantityCreated(1);
    }

    public void deleteBarCode(String barCodeId) {
        barCodes.remove(barCodeId);
        decrementQuantityCreated(1);
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
        quantityCreated = barCodes.size();
    }

    public int getQuantityCreated() {
        return quantityCreated;
    }

    public void setQuantityCreated(int quantityCreated) {
        this.quantityCreated = quantityCreated;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public int getQuantityUnused() {
        return quantityCreated - quantityUsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Glasses{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", quantityCreated=").append(quantityCreated);
        sb.append('}');
        return sb.toString();
    }
}
