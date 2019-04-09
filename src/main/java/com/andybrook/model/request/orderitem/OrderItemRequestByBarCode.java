package com.andybrook.model.request.orderitem;

import com.andybrook.model.request.AbstractRequest;

public class OrderItemRequestByBarCode extends AbstractRequest {

    private final String barCodeId;

    public OrderItemRequestByBarCode(String barCodeId) {
        this.barCodeId = barCodeId;
    }

    public String getBarCodeId() {
        return barCodeId;
    }

    @Override
    public String toString() {
        return "OrderItemRequestByBarCode{" +
                "barCodeId='" + barCodeId + '\'' +
                '}';
    }
}
