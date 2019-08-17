package com.andybrook.serialization.jackson;

import com.andybrook.exception.SerializerException;
import com.andybrook.serialization.ISerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

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
            throw new JacksonSerializerException(e);
        }
        return serializedMsg;
    }

    @Override
    public <T> String serializeToString(T msg) throws SerializerException {
        String serializedMsg;
        try {
            serializedMsg = objectMapper.writeValueAsString(msg);
        } catch (JsonProcessingException e) {
            throw new JacksonSerializerException(e);
        }
        return serializedMsg;
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        T payload;
        try {
            payload = objectMapper.readValue(data, clazz);
        } catch (IOException e) {
            throw new JacksonSerializerException(e);
        }
        return payload;
    }

    @Override
    public <T> T deserialize(String data, Class<T> clazz) {
        T payload;
        try {
            payload = objectMapper.readValue(data, clazz);
        } catch (IOException e) {
            throw new JacksonSerializerException(e);
        }
        return payload;
    }

    private class JacksonSerializerException extends SerializerException {

        private JacksonSerializerException(Throwable cause) {
            super(cause);
        }
    }
}
