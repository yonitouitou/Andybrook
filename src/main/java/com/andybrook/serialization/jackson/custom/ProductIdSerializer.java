package com.andybrook.serialization.jackson.custom;

import com.andybrook.model.product.ProductId;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProductIdSerializer extends JsonSerializer<ProductId> {

    @Override
    public void serialize(ProductId productId, JsonGenerator json, SerializerProvider serializerProvider) throws IOException {
        json.writeStartObject();
        json.writeStringField("id", productId.get());
        json.writeStringField("productType", productId.getProductType().name());
        json.writeEndObject();
    }
}
