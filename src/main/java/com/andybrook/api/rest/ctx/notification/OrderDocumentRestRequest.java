package com.andybrook.api.rest.ctx.notification;

import com.andybrook.api.rest.jackson.OrderDocumentRestRequestJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = OrderDocumentRestRequestJsonSerializer.class)
public class OrderDocumentRestRequest extends DocumentRestRequest {

    protected long orderId;

    public OrderDocumentRestRequest() {
        super();
    }

    public long getOrderId() {
        return orderId;
    }

    public OrderDocumentRestRequest setOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDocumentRestRequest{");
        sb.append("orderId=").append(orderId);
        sb.append("dateDocument=").append(dateDocument);
        sb.append('}');
        return sb.toString();
    }
}
