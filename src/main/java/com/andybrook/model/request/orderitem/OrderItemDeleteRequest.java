package com.andybrook.model.request.orderitem;

public class OrderItemDeleteRequest extends OrderItemRequest {

    protected long orderItemId;

    public OrderItemDeleteRequest(long orderId, long orderItemId) {
        super(orderId);
        this.orderItemId = orderItemId;
    }

    public static boolean isValid(OrderItemDeleteRequest request) {
        return request != null;
    }

    public long getOrderItemId() {
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
