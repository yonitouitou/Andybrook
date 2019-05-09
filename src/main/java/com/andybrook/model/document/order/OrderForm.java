package com.andybrook.model.document.order;

import com.andybrook.enums.DocType;
import com.andybrook.model.document.AbstractDocument;

import java.time.LocalDateTime;

public class OrderForm extends AbstractDocument {

    private long orderId;
    private long customerId;

    public OrderForm(Long id, byte[] data, LocalDateTime createdDatetime, long orderId, long customerId) {
        super(id, data, createdDatetime);
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public OrderForm(byte[] data, long orderId) {
        super(data);
        this.orderId = orderId;
    }

    @Override
    public DocType getType() {
        return DocType.ORDER_FORM;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
