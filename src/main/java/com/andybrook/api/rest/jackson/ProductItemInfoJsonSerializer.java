package com.andybrook.api.rest.jackson;

import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class ProductItemInfoJsonSerializer extends JsonDeserializer<ProductItemInfo> {

    @Override
    public ProductItemInfo deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        Long id = json.get("orderItemId") == null || json.get("orderItemId").asText().isEmpty() ? null : json.get("orderItemId").asLong();
        long productId = json.get("productId").asLong();
        int quantity = json.get("requestedQty").asInt();
        return new ProductItemInfo(id, productId, quantity);
    }
}
