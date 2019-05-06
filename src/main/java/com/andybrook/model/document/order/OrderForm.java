package com.andybrook.model.document.order;

import com.andybrook.enums.DocType;
import com.andybrook.model.document.AbstractDocument;

import java.time.LocalDateTime;

public class OrderForm extends AbstractDocument {

    private long orderId;

    public OrderForm(Long id, byte[] data, LocalDateTime createdDatetime, long orderId) {
        super(id, data, createdDatetime);
        this.orderId = orderId;
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
}
