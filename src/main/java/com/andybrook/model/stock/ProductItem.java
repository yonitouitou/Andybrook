package com.andybrook.model.stock;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.util.clock.Clock;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.util.Assert;

@Document(indexName = "product_items")
public class ProductItem {

    private long id;
    private ProductId productId;
    private BarCode barCode;
    private String orderItemId;
    private long createdDatetime;
    private long lastModifiedDatetime;

    private ProductItem() {}

    public ProductItem(ProductId productId, BarCode barCode) {
        Assert.notNull(productId, "The product ID cannot be null");
        this.id = Clock.nanos();
        this.productId = productId;
        this.barCode = barCode;
        this.orderItemId = null;
        this.createdDatetime = Clock.millis();
        this.lastModifiedDatetime = createdDatetime;
    }

    public ProductItem(Product product, BarCode barCode) {
        this(product.getId(), barCode);
    }

    public void markAsUsed(String orderItemId) {
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

    public long getCreatedDatetime() {
        return createdDatetime;
    }

    public long getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
        this.lastModifiedDatetime = Clock.millis();
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
