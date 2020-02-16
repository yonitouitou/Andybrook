package com.andybrook.model.request.orderitem;

public class OrderItemDeleteRequest extends OrderItemRequest {

    protected String orderItemId;

    public OrderItemDeleteRequest(long orderId, String orderItemId) {
        super(orderId);
        this.orderItemId = orderItemId;
    }

    public static boolean isValid(OrderItemDeleteRequest request) {
        return request != null;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    @Override
    public String toString() {
        return "OrderItemDeleteRequest{" +
                "orderItemId=" + orderItemId +
                ", orderId=" + orderId +
                '}';
    }
}
