package com.andybrook.model.stock;

import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;

import java.time.LocalDateTime;
import java.util.OptionalLong;

public class ProductItem {

    private Long id;
    private Product product;
    private BarCode barCode;
    private OptionalLong orderItemIdOpt;
    protected LocalDateTime createdDatetime;
    protected LocalDateTime lastModifiedDatetime;

    public ProductItem(Product product, BarCode barCode) {
        this.product = product;
        this.barCode = barCode;
        this.orderItemIdOpt = OptionalLong.empty();
    }

    public ProductItem(Long id, Product product, BarCode barCode) {
        this.id = id;
        this.product = product;
        this.barCode = barCode;
        this.orderItemIdOpt = OptionalLong.empty();
    }

    public void markAsUsed(long orderItemId) {
        orderItemIdOpt = OptionalLong.of(orderItemId);
    }

    public boolean isInOrder() {
        return orderItemIdOpt.isPresent();
    }

    public double getPrice() {
        return product.getPrice();
    }

    public String getName() {
        return product.getName();
    }

    public long getProductId() {
        return product.getId();
    }

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

    public OptionalLong getOrderItemIdOpt() {
        return orderItemIdOpt;
    }

    public void setOrderItemIdOpt(OptionalLong orderItemIdOpt) {
        if (orderItemIdOpt == null) {
            this.orderItemIdOpt = OptionalLong.empty();
        } else {
            this.orderItemIdOpt = orderItemIdOpt;
        }
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "id=" + id +
                ", product=" + product +
                ", barCode=" + barCode +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDatetime=" + lastModifiedDatetime +
                '}';
    }
}