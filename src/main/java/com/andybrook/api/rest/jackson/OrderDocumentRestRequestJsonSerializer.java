package com.andybrook.api.rest.jackson;

import com.andybrook.api.rest.ctx.notification.OrderDocumentRestRequest;
import com.andybrook.enums.NotificationType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class OrderDocumentRestRequestJsonSerializer extends JsonDeserializer<OrderDocumentRestRequest> {

    @Override
    public OrderDocumentRestRequest deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        NotificationType type = NotificationType.valueOf(json.get("notificationType").asText());
        OrderDocumentRestRequest req = new OrderDocumentRestRequest(type);
        req.setOrderId(json.get("orderId").asLong());
        req.setDateDocument(json.get("dateDocument").asLong());
        return req;
    }
}
