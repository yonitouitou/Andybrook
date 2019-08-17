package com.andybrook.serialization;

import com.andybrook.exception.SerializerException;

public interface ISerializer {

    <T> byte[] serialize(T msg) throws SerializerException;

    <T> String serializeToString(T msg) throws SerializerException;

    <T> T deserialize(byte[] data, Class<T> clazz);

    <T> T deserialize(String data, Class<T> clazz);
}
