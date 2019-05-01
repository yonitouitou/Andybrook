package com.andybrook.api.rest.ctx;

import com.andybrook.model.request.orderitem.ProductItemInfo;

public class OrderItemAddRequestByInfo extends OrderItemRestRequest {

    private int requestedQty;
    private long productId;
    private String barCode;
    private ProductItemInfo productItemInfo = null;

    public void setProductItemInfo(ProductItemInfo productItemInfo) {
        this.productItemInfo = productItemInfo;
    }

    public ProductItemInfo getProductItemInfo() {
        if (productItemInfo == null) {
            productItemInfo = new ProductItemInfo(productId, requestedQty);
        }
        return productItemInfo;
    }

    public int getRequestedQty() {
        return requestedQty;
    }

    public void setRequestedQty(int requestedQty) {
        this.requestedQty = requestedQty;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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
                "productItemInfo=" + productItemInfo +
                '}';
    }
}
