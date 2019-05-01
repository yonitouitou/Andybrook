package com.andybrook.api.rest.ctx;

import com.andybrook.model.request.orderitem.OrderItemRequest;

import java.util.Arrays;

public class DeleteOrderItemRestRequest extends OrderItemRequest {

    private Long[] orderItemsId;

    private DeleteOrderItemRestRequest() {
        super(-1);
    }

    public DeleteOrderItemRestRequest(long orderId) {
        super(orderId);
    }

    public Long[] getOrderItemsId() {
        return orderItemsId;
    }

    @Override
    public String toString() {
        return "DeleteOrderItemRestRequest{" +
                "orderItemsId=" + Arrays.toString(orderItemsId) +
                ", orderId=" + orderId +
                '}';
    }
}
