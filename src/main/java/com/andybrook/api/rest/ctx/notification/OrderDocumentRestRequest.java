package com.andybrook.api.rest.ctx.notification;

import com.andybrook.api.rest.jackson.OrderDocumentRestRequestJsonDeserializer;
import com.andybrook.enums.DocType;
import com.andybrook.enums.FileFormat;
import com.andybrook.enums.NotificationType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Arrays;
import java.util.List;

@JsonDeserialize(using = OrderDocumentRestRequestJsonDeserializer.class)
public class OrderDocumentRestRequest extends DocumentRestRequest {

    protected long orderId;

    public OrderDocumentRestRequest(NotificationType[] notifTypes, DocType docType, long dateDocument,
                                    FileFormat[] fileFormats, long orderId) {
        super(notifTypes, docType, dateDocument, fileFormats, new String[] {});
        this.orderId = orderId;
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
        sb.append(", docType=").append(docType);
        sb.append(", dateDocument=").append(dateDocument);
        sb.append(", fileFormats=").append(Arrays.toString(fileFormats));
        sb.append(", emails=").append(Arrays.toString(emails));
        sb.append('}');
        return sb.toString();
    }
}
