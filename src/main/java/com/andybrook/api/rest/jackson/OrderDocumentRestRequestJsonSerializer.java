package com.andybrook.api.rest.jackson;

import com.andybrook.api.pdf.CloseOrderPdfBuilder;
import com.andybrook.api.rest.ctx.notification.OrderDocumentRestRequest;
import com.andybrook.enums.NotificationType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.LinkedList;
import java.util.List;

public class OrderDocumentRestRequestJsonSerializer extends JsonDeserializer<OrderDocumentRestRequest> {

    private static final Logger LOGGER = System.getLogger(OrderDocumentRestRequestJsonSerializer.class.getSimpleName());

    @Override
    public OrderDocumentRestRequest deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        List<NotificationType> types = new LinkedList<>();
        JsonNode jsonNodeTypes = json.get("types");
        for (JsonNode jsonNodeType : jsonNodeTypes) {
            try {
                types.add(NotificationType.valueOf(jsonNodeType.asText()));
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, "Unknown NotificationType : " + jsonNodeType.asText());
            }
        }
        OrderDocumentRestRequest req = new OrderDocumentRestRequest(types);
        req.setOrderId(json.get("orderId").asLong());
        req.setDateDocument(json.get("dateDocument").asLong());
        return req;
    }
}
