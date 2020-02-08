package com.andybrook.model.stock;

import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class ProductItem {

    private Long id;
    private Product product;
    private BarCode barCode;
    private Long orderItemId;
    protected LocalDateTime createdDatetime;
    protected LocalDateTime lastModifiedDatetime;

    private ProductItem() {}

    public ProductItem(Product product, BarCode barCode) {
        this.product = product;
        this.barCode = barCode;
        this.orderItemId = null;
    }

    public ProductItem(Long id, Product product, BarCode barCode) {
        this.id = id;
        this.product = product;
        this.barCode = barCode;
        this.orderItemId = null;
    }

    public void markAsUsed(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    @JsonIgnore
    public boolean isInOrder() {
        return orderItemId != null;
    }

    @JsonIgnore
    public double getPrice() {
        return product.getPrice();
    }

    @JsonIgnore
    public String getName() {
        return product.getName();
    }

    @JsonIgnore
    public ProductId getProductId() {
        return product.getId();
    }

    @JsonIgnore
    public ProductType getProductType() {
        return product.getType();
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public BarCode getBarCode() {
        return barCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "id=" + id +
                ", product=" + product +
                ", barCode=" + barCode +
                ", orderItemId=" + orderItemId +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                '}';
    }
}
