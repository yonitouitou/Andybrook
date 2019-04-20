package com.andybrook.exception;

public class ProductItemNotFree extends ValidationRuntimeException {

    public ProductItemNotFree(long productItemId) {
        super(String.valueOf(productItemId));
    }
}
