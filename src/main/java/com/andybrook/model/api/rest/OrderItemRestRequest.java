package com.andybrook.model.api.rest;

import com.andybrook.api.rest.jackson.OrderItemInfoJsonSerializer;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class OrderItemRestRequest {

    private long orderId;

    @JsonDeserialize(using = OrderItemInfoJsonSerializer.class)
    private OrderItemInfo orderItemInfo;

    public OrderItemRestRequest(long orderId, OrderItemInfo orderItemInfo) {
        this.orderId = orderId;
        this.orderItemInfo = orderItemInfo;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public OrderItemInfo getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    @Override
    public String toString() {
        return "OrderItemRestRequest{" +
                "orderId=" + orderId +
                ", orderItemInfo=" + orderItemInfo +
                '}';
    }
}
