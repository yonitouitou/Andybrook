package com.andybrook.model.request.orderitem;

import com.andybrook.model.request.AbstractRequest;

public abstract class OrderItemRequest extends AbstractRequest {

    protected final long orderId;

    public abstract String toString();

    public OrderItemRequest(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }
}
