package com.andybrook.api.rest.jackson;

import com.andybrook.api.rest.ctx.customer.AddOrUpdateStoreRestRequest;
import com.andybrook.model.common.Address;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class AddOrUpdateCustomerRestRequestJsonDeserializer extends JsonDeserializer<AddOrUpdateStoreRestRequest> {

    @Override
    public AddOrUpdateStoreRestRequest deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        AddOrUpdateStoreRestRequest req = new AddOrUpdateStoreRestRequest();
        req.setCustomerId(hasNumericValue(json, "customerId") ? json.get("customerId").asLong() : null);
        req.setOwnerId(hasNumericValue(json, "ownerId") ? json.get("ownerId").asLong() : null);
        req.setOwnerCompagnyName(hasStringValue(json, "ownerCompagnyName") ? json.get("ownerCompagnyName").asText() : null);
        req.setOwnerFirstName(hasStringValue(json, "ownerFirstName") ? json.get("ownerFirstName").asText() : null);
        req.setOwnerLastName(hasStringValue(json, "ownerLastName") ? json.get("ownerLastName").asText() : null);
        req.setOwnerEmail(hasStringValue(json, "ownerEmail") ? json.get("ownerEmail").asText() : null);
        req.setStoreId(hasStringValue(json, "storeId") ? json.get("storeId").asLong() : null);
        req.setStoreName(hasStringValue(json, "storeName") ? json.get("storeName").asText() : null);
        req.setStoreEmail(hasStringValue(json, "storeEmail") ? json.get("storeEmail").asText() : null);
        req.setStorePhone(hasStringValue(json, "storePhone") ? json.get("storePhone").asText() : null);

        if (json.has("storeAddress")) {
            JsonNode jsonAddr = json.get("storeAddress");
            String storeStreetNumber = (hasStringValue(jsonAddr, "streetNumber") ? jsonAddr.get("streetNumber").asText() : null);
            String storeStreetName = (hasStringValue(jsonAddr, "streetName") ? jsonAddr.get("streetName").asText() : null);
            String storeCity = (hasStringValue(jsonAddr, "city") ? jsonAddr.get("city").asText() : null);
            String storeCountry = (hasStringValue(jsonAddr, "country") ? jsonAddr.get("country").asText() : null);
            Integer storeZipCode = (hasNumericValue(jsonAddr, "zipCode") ? jsonAddr.get("zipCode").asInt() : null);
            req.setStoreAddress(new Address(storeStreetNumber, storeStreetName, storeCity, storeCountry, storeZipCode));
        }
        return req;
    }

    private static boolean hasStringValue(JsonNode json, String fieldName) {
        return json.has(fieldName) && ! StringUtils.isEmpty(json.get(fieldName));
    }

    private static boolean hasNumericValue(JsonNode json, String fieldName) {
        return json.has(fieldName) && json.get(fieldName) != null;
    }
}
