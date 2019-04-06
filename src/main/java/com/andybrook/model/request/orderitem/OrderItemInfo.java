package com.andybrook.model.request.orderitem;

public class OrderItemInfo {

    protected Long id;
    protected long productId;
    protected String barCodeId;
    protected int quantity;

    public OrderItemInfo(Long id, long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderItemInfo(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderItemInfo(long id) {
        this.id = id;
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

    public String getBarCodeId() {
        return barCodeId;
    }

    public void setBarCodeId(String barCodeId) {
        this.barCodeId = barCodeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
