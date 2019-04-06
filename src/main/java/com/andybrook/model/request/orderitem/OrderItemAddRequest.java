package com.andybrook.model.request.orderitem;

public class OrderItemAddRequest extends OrderItemRequest {

    private final OrderItemInfo orderItemInfo;

    public OrderItemAddRequest(long orderId, OrderItemInfo orderItemInfo) {
        super(orderId);
        this.orderItemInfo = orderItemInfo;
    }

    public static boolean isValid(OrderItemAddRequest request) {
        boolean isValid;
        if (request != null && request.getOrderItemInfo() != null) {
            isValid = request.getOrderItemInfo().getQuantity() > 0;
        } else {
            isValid = false;
        }
        return isValid;
    }

    public OrderItemInfo getOrderItemInfo() {
        return orderItemInfo;
    }

    @Override
    public String toString() {
        return "OrderItemAddRequest{" +
                "orderItemInfo=" + orderItemInfo +
                ", orderId=" + orderId +
                '}';
    }
}
