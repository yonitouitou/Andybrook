package com.andybrook.model.request.orderitem;

public class OrderItemAddRequest extends OrderItemRequest {

    private final OrderItemInfo orderItemInfo;
    private final int quantityRequested;

    public OrderItemAddRequest(long orderId, OrderItemInfo orderItemInfo) {
        super(orderId);
        this.orderItemInfo = orderItemInfo;
        this.quantityRequested = orderItemInfo.getRequestedQuantity();
    }

    public static boolean isValid(OrderItemAddRequest request) {
        return request != null && request.getOrderItemInfo() != null && request.getQuantityRequested() > 0;
    }

    public OrderItemInfo getOrderItemInfo() {
        return orderItemInfo;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    @Override
    public String toString() {
        return "OrderItemAddRequest{" +
                "productItemInfo=" + orderItemInfo +
                ", orderId=" + orderId +
                '}';
    }
}
