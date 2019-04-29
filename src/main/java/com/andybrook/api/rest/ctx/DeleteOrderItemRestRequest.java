package com.andybrook.api.rest.ctx;

import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.orderitem.OrderItemRequest;

import java.util.Arrays;

public class DeleteOrderItemRestRequest extends OrderItemRequest {

    private OrderItem[] orderItems;

    private DeleteOrderItemRestRequest() {
        super(-1);
    }

    public DeleteOrderItemRestRequest(long orderId) {
        super(orderId);
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "DeleteOrderItemRestRequest{" +
                "orderItems=" + Arrays.toString(orderItems) +
                ", orderId=" + orderId +
                '}';
    }
}
