package com.andybrook.model.request;

import com.andybrook.api.rest.jackson.StockItemJsonSerializer;
import com.andybrook.model.product.Product;
import com.andybrook.model.OrderItem;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class OrderItemUpdateRequest {

    private long orderId;
    @JsonDeserialize(using = StockItemJsonSerializer.class)
    private OrderItem<? extends Product> orderItem;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public OrderItem<? extends Product> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem<? extends Product> orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public String toString() {
        return "OrderItemUpdateRequest{" +
                "orderId=" + orderId +
                ", orderItem=" + orderItem +
                '}';
    }
}
