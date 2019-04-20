package com.andybrook.model.request.orderitem;

import org.springframework.util.StringUtils;

public class OrderItemAddRequestByBarCode {

    private final long orderId;
    private final String barCodeId;

    public OrderItemAddRequestByBarCode(long orderId, String barCodeId) {
        this.orderId = orderId;
        this.barCodeId = barCodeId;
    }

    public static boolean isValid(OrderItemAddRequestByBarCode request) {
        return request.orderId > 0 && ! StringUtils.isEmpty(request.barCodeId);
    }

    public String getBarCodeId() {
        return barCodeId;
    }

    public long getOrderId() {
        return orderId;
    }
}
