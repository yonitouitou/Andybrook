package com.andybrook.model.stock;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Document(indexName = "product_items")
public class ProductItem {

    private Long id;
    private ProductId productId;
    private BarCode barCode;
    private Long orderItemId;
    protected LocalDateTime createdDatetime;
    protected LocalDateTime lastModifiedDatetime;

    private ProductItem() {}

    public ProductItem(ProductId productId, BarCode barCode) {
        Assert.notNull(productId, "The product ID cannot be null");
        this.productId = productId;
        this.barCode = barCode;
        this.orderItemId = null;
    }

    public ProductItem(Product product, BarCode barCode) {
        this(product.getId(), barCode);
    }

    public ProductItem(Long id, Product product, BarCode barCode) {
        this(product.getId(), barCode);
        this.id = id;
    }

    public void markAsUsed(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    @JsonIgnore
    public boolean isInOrder() {
        return orderItemId != null;
    }

    @JsonIgnore
    public ProductId getProductId() {
        return productId;
    }

    public Long getId() {
        return id;
    }

    public BarCode getBarCode() {
        return barCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(ProductId id) {
        this.productId = id;
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
                ", productId=" + productId +
                ", barCode=" + barCode +
                ", orderItemId=" + orderItemId +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                '}';
    }
}
