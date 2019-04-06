package com.andybrook.exception;

public class ProductNotFound extends ValidationRuntimeException {

    public ProductNotFound(long id) {
        super("Product not found : " + String.valueOf(id));
    }
}
