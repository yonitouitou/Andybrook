package com.andybrook.api.rest.jackson;

import com.andybrook.api.rest.ctx.notification.OrderDocumentRestRequest;
import com.andybrook.enums.DocType;
import com.andybrook.enums.FileFormat;
import com.andybrook.enums.NotificationType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.LinkedList;
import java.util.List;

public class OrderDocumentRestRequestJsonDeserializer extends JsonDeserializer<OrderDocumentRestRequest> {

    @Override
    public OrderDocumentRestRequest deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode json = oc.readTree(jp);
        DocType docType = DocType.valueOf(json.get("docType").asText());
        NotificationType[] notifTypes = new NotificationType[] {NotificationType.DOWNLOAD, NotificationType.EMAIL};
        long dateDocument = json.get("dateDocument").asLong();
        long orderId = json.get("orderId").asLong();
        FileFormat[] fileFormats = new FileFormat[] {FileFormat.PDF, FileFormat.CSV};
        OrderDocumentRestRequest req = new OrderDocumentRestRequest(notifTypes, docType, dateDocument, fileFormats, orderId);
        req.setEmails(extractEmails(json));
        return req;
    }

    private String[] extractEmails(JsonNode jsonNode) {
        JsonNode jsonNodeEmails = jsonNode.get("emails");
        String[] emails = new String[jsonNodeEmails.size()];
        for (int i = 0; i < jsonNodeEmails.size(); i++) {
            String email = jsonNodeEmails.get(i).asText();
            if (! StringUtils.isEmpty(email)) {
                emails[i] = email;
            }
        }
        return emails;
    }
}
