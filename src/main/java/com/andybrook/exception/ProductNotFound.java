package com.andybrook.exception;

public class ProductNotFound extends Exception {

    public ProductNotFound(long id) {
        super("Product not found : " + String.valueOf(id));
    }
}
