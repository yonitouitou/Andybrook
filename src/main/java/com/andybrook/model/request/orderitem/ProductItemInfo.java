package com.andybrook.model.request.orderitem;

public class ProductItemInfo {

    protected Long id;
    protected long productId;
    protected int requestedQuantity;

    public ProductItemInfo(Long id, long productId, int requestedQuantity) {
        this.id = id;
        this.productId = productId;
        this.requestedQuantity = requestedQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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
