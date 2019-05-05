package com.andybrook.api.rest.ctx;

public class OrderItemAddByBarCodeRestRequest extends OrderItemRestRequest {

    private String barCode;

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    @Override
    public String toString() {
        return "OrderItemAddByBarCodeRestRequest{" +
                "barCode='" + barCode + '\'' +
                '}';
    }
}
