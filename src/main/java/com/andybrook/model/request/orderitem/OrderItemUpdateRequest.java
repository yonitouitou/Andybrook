package com.andybrook.model.request.orderitem;

public class OrderItemUpdateRequest extends OrderItemRequest {

    private final OrderItemInfo orderItemInfo;

    public OrderItemUpdateRequest(long orderId, OrderItemInfo orderItemInfo) {
        super(orderId);
        this.orderItemInfo = orderItemInfo;
    }

    public static boolean isValid(OrderItemUpdateRequest request) {
        boolean isValid;
        if (request != null) {
            OrderItemInfo info = request.getOrderItemInfo();
            isValid = info.getId() != null && info.getQuantity() >= 0;
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
        return "OrderItemUpdateRequest{" +
                "orderItemInfo=" + orderItemInfo +
                ", orderId=" + orderId +
                '}';
    }
}
