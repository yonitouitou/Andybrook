package com.andybrook.api.rest.jackson;

import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class StockItemJsonSerializer extends JsonDeserializer<StockItem<? extends Product>> {

    @Override
    public StockItem<? extends Product> deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        Long id = json.get("id").asText().isEmpty() ? null : json.get("id").asLong();
        int quantity = json.get("quantity").asInt(0);
        ProductType productType = ProductType.valueOf(json.get("type").asText().toUpperCase());
        JsonNode productNode = json.get("product");
        Product product = null;
        if (productType == ProductType.GLASSES) {
            Long productId = productNode.get("id").asText().isEmpty() ? null : productNode.get("id").asLong() ;
            String name = productNode.get("name").asText();
            double price = productNode.get("price").asDouble(0d);
            product = new Glasses(productId, name, price);
        } else {
            throw new RuntimeException("Unknown product type in the request : " + json.asText());
        }
        return new StockItem(id, product, productType, quantity);
    }
}
