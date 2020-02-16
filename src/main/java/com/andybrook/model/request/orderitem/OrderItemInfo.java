package com.andybrook.model.request.orderitem;

import com.andybrook.model.product.ProductId;

public class OrderItemInfo {

    protected String id;
    protected ProductId productId;
    protected int requestedQuantity;

    public OrderItemInfo(ProductId productId, int requestedQuantity) {
        this.id = null;
        this.productId = productId;
        this.requestedQuantity = requestedQuantity;
    }

    public OrderItemInfo(String id, ProductId productId, int requestedQuantity) {
        this.id = id;
        this.productId = productId;
        this.requestedQuantity = requestedQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    @Override
    public String toString() {
        return "ProductItemInfo{" +
                "id=" + id +
                ", productId=" + productId +
                ", requestedQuantity=" + requestedQuantity +
                '}';
    }
}
