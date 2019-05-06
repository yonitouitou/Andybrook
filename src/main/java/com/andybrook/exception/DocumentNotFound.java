package com.andybrook.exception;

public class DocumentNotFound extends ValidationRuntimeException {

    public DocumentNotFound(long id) {
        super(String.valueOf(id));
    }
}
