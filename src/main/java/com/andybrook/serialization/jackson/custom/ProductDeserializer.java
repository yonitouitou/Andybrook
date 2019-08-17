package com.andybrook.serialization.jackson.custom;

import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class ProductDeserializer extends JsonDeserializer<Product> {

    @Override
    public Product deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        long id = json.get("id").asLong();
        String name = json.get("name").asText();
        double price = json.get("price").asDouble();
        ProductType type = ProductType.valueOf(json.get("type").asText());
        Product product;
        switch (type) {
            case GLASSES:
                product = new Glasses(id, name, price);
                break;
            default:
                throw new UnsupportedOperationException("Unknown ProductType : " + type);
        }
        return product;
    }
}
