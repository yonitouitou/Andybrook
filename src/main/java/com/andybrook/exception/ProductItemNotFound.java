package com.andybrook.exception;

public class ProductItemNotFound extends ValidationRuntimeException {

    public ProductItemNotFound(long id) {
        super(String.valueOf(id));
    }
}
