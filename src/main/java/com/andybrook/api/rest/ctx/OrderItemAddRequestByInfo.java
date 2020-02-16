package com.andybrook.api.rest.ctx;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.request.orderitem.OrderItemInfo;

public class OrderItemAddRequestByInfo extends OrderItemRestRequest {

    private int requestedQty;
    private ProductId productId;
    private String barCode;
    private OrderItemInfo orderItemInfo = null;

    public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    public OrderItemInfo getOrderItemInfo() {
        if (orderItemInfo == null) {
            orderItemInfo = new OrderItemInfo(productId, requestedQty);
        }
        return orderItemInfo;
    }

    public int getRequestedQty() {
        return requestedQty;
    }

    public void setRequestedQty(int requestedQty) {
        this.requestedQty = requestedQty;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public String toString() {
        return "OrderItemAddRequestByInfo{" +
                "productItemInfo=" + orderItemInfo +
                '}';
    }
}
