package com.andybrook.api.rest.ctx;

public class GenericStockItemChangeRequest {

    private long orderId;
    private long stockItemId;

    public GenericStockItemChangeRequest() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(long stockItemId) {
        this.stockItemId = stockItemId;
    }
}
