package com.andybrook.model.stock;

import com.andybrook.model.product.Product;

public final class ProductStockInfo {

    protected Product product;
    protected int quantityCreated;
    protected int quantityUsed;

    public ProductStockInfo(Product product, int quantityCreated, int quantityUsed) {
        this.product = product;
        this.quantityCreated = quantityCreated;
        this.quantityUsed = quantityUsed;
    }

    public void incrementQuantityCreated(int qtyToIncrement) {
        quantityCreated += qtyToIncrement;
    }

    public void decrementQuantityCreated(int qtyToDecrement) {
        quantityCreated -= qtyToDecrement;
    }

    public void incrementQuantityUsed() {
        incrementQuantityUsed(1);
    }

    public void incrementQuantityUsed(int qtyToIncrement) {
        quantityUsed += qtyToIncrement;
    }

    public void decrementQuantityUsed() {
        decrementQuantityUsed(1);
    }

    public void decrementQuantityUsed(int qtyToDecrement) {
        quantityUsed -= qtyToDecrement;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
