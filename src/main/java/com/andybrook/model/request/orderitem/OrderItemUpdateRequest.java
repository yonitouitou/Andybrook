package com.andybrook.model.request.orderitem;

public class OrderItemUpdateRequest extends OrderItemRequest {

    private final ProductItemInfo productItemInfo;
    private final int quantity;

    public OrderItemUpdateRequest(long orderId, int quantity, ProductItemInfo productItemInfo) {
        super(orderId);
        this.quantity = quantity;
        this.productItemInfo = productItemInfo;
    }

    public static boolean isValid(OrderItemUpdateRequest request) {
        boolean isValid;
        if (request != null) {
            ProductItemInfo info = request.getProductItemInfo();
            isValid = info.getId() != null;
        } else {
            isValid = false;
        }
        return isValid;
    }

    public ProductItemInfo getProductItemInfo() {
        return productItemInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItemUpdateRequest{" +
                "productItemInfo=" + productItemInfo +
                ", quantity=" + quantity +
                ", orderId=" + orderId +
                '}';
    }
}
