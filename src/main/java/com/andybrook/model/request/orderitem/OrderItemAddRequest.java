package com.andybrook.model.request.orderitem;

public class OrderItemAddRequest extends OrderItemRequest {

    private final ProductItemInfo productItemInfo;
    private final int quantityRequested;

    public OrderItemAddRequest(long orderId, ProductItemInfo productItemInfo) {
        super(orderId);
        this.productItemInfo = productItemInfo;
        this.quantityRequested = productItemInfo.getRequestedQuantity();
    }

    public static boolean isValid(OrderItemAddRequest request) {
        return request != null && request.getProductItemInfo() != null && request.getQuantityRequested() > 0;
    }

    public ProductItemInfo getProductItemInfo() {
        return productItemInfo;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    @Override
    public String toString() {
        return "OrderItemAddRequest{" +
                "productItemInfo=" + productItemInfo +
                ", orderId=" + orderId +
                '}';
    }
}
