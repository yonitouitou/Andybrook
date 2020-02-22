package com.andybrook.serialization.jackson.custom;

import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class ProductDeserializer extends JsonDeserializer<Product> {

    @Override
    public Product deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        long id = json.get("id").asLong();
        ProductType productType = ProductType.valueOf(json.get("productId.productType").asText());
        ProductId productId = new ProductId(productType, id);
        String name = json.get("name").asText();
        double price = json.get("price").asDouble();
        Product product;
        switch (productType) {
            case GLASSES:
                product = new Glasses(productId, name, price);
                break;
            default:
                throw new UnsupportedOperationException("Unknown ProductType : " + productType);
        }
        return product;
    }
}
