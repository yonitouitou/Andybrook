package com.andybrook.model.request.orderitem;

public class OrderItemUpdateRequest extends OrderItemRequest {

    private final OrderItemInfo orderItemInfo;
    private final int quantity;

    public OrderItemUpdateRequest(long orderId, int quantity, OrderItemInfo orderItemInfo) {
        super(orderId);
        this.quantity = quantity;
        this.orderItemInfo = orderItemInfo;
    }

    public static boolean isValid(OrderItemUpdateRequest request) {
        boolean isValid;
        if (request != null) {
            OrderItemInfo info = request.getOrderItemInfo();
            isValid = info.getId() != null;
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
                ", quantity=" + quantity +
                ", orderId=" + orderId +
                '}';
    }
}
