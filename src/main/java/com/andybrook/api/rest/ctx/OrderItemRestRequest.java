package com.andybrook.api.rest.ctx;

public class OrderItemRestRequest {

    private long orderId;

    public OrderItemRestRequest() {}

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }



    @Override
    public String toString() {
        return "OrderItemRestRequest{" +
                "orderId=" + orderId +
                '}';
    }
}
