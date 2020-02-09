package com.andybrook.model.stock;

import com.andybrook.model.product.ProductId;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "products_stock_info")
public final class ProductStockInfo {

    @Id
    protected ProductId productId;
    protected int quantityCreated;
    protected int quantityUsed;

    public ProductStockInfo(ProductId productId, int quantityCreated, int quantityUsed) {
        this.productId = productId;
        this.quantityCreated = quantityCreated;
        this.quantityUsed = quantityUsed;
    }

    public void incrementQuantityCreated() {
        incrementQuantityCreated(1);
    }


    public void incrementQuantityCreated(int qtyToIncrement) {
        quantityCreated += qtyToIncrement;
    }

    public void decrementQuantityCreated() {
        decrementQuantityCreated(1);
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

    public ProductId getProductId() {
        return productId;
    }

    public void setProduct(ProductId productId) {
        this.productId = productId;
    }
}
