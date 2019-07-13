package com.andybrook.serialization;

import com.andybrook.exception.SerializerException;

public interface ISerializer {

    <T> byte[] serialize(T msg) throws SerializerException;

    <T> String serializeToString(T msg) throws SerializerException;
}
