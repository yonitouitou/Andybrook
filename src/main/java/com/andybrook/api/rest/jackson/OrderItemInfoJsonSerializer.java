package com.andybrook.api.rest.jackson;

import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class OrderItemInfoJsonSerializer extends JsonDeserializer<OrderItemInfo> {

    @Override
    public OrderItemInfo deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        Long id = json.get("id") == null || json.get("id").asText().isEmpty() ? null : json.get("id").asLong();
        int quantity = json.get("quantityCreated").asInt(0);
        long productId = json.get("productId").asLong();
        return new OrderItemInfo(id, productId, quantity);
    }
}
