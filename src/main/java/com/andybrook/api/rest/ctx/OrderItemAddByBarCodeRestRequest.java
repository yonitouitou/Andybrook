package com.andybrook.api.rest.ctx;

public class OrderItemAddByBarCodeRestRequest extends OrderItemRestRequest {

    private final String barCodeId;

    public OrderItemAddByBarCodeRestRequest(String barCodeId) {
        this.barCodeId = barCodeId;
    }

    public String getBarCodeId() {
        return barCodeId;
    }

    @Override
    public String toString() {
        return "OrderItemAddByBarCodeRestRequest{" +
                "barCodeId='" + barCodeId + '\'' +
                '}';
    }
}
