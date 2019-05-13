package com.andybrook.api.rest.ctx.notification;

import com.andybrook.api.rest.jackson.OrderDocumentRestRequestJsonSerializer;
import com.andybrook.enums.NotificationType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = OrderDocumentRestRequestJsonSerializer.class)
public class OrderDocumentRestRequest extends DocumentRestRequest {

    protected long orderId;

    public OrderDocumentRestRequest(List<NotificationType> types) {
        super(types);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
