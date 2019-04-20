package com.andybrook.api.rest.ctx;

import com.andybrook.api.rest.jackson.ProductItemInfoJsonSerializer;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class OrderItemAddRequestByInfo extends OrderItemRestRequest {

    @JsonDeserialize(using = ProductItemInfoJsonSerializer.class)
    private ProductItemInfo productItemInfo;

    public ProductItemInfo getProductItemInfo() {
        return productItemInfo;
    }

    public void setProductItemInfo(ProductItemInfo productItemInfo) {
        this.productItemInfo = productItemInfo;
    }

    @Override
    public String toString() {
        return "OrderItemAddRequestByInfo{" +
                "productItemInfo=" + productItemInfo +
                '}';
    }
}
