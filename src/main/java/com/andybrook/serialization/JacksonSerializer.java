package com.andybrook.serialization;

import com.andybrook.exception.SerializerException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer implements ISerializer {

    private ObjectMapper objectMapper;

    public JacksonSerializer() {
        this.objectMapper = new ObjectMapper();
    }

    public JacksonSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> byte[] serialize(T msg) throws SerializerException {
        byte[] serializedMsg;
        try {
            serializedMsg = objectMapper.writeValueAsBytes(msg);
        } catch (JsonProcessingException e) {
            throw new JacksonSerializerException();
        }
        return serializedMsg;
    }

    @Override
    public <T> String serializeToString(T msg) throws SerializerException {
        String serializedMsg;
        try {
            serializedMsg = objectMapper.writeValueAsString(msg);
        } catch (JsonProcessingException e) {
            throw new JacksonSerializerException();
        }
        return serializedMsg;
    }

    public class JacksonSerializerException extends SerializerException {}
}
