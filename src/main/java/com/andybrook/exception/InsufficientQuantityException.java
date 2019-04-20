package com.andybrook.exception;

public class InsufficientQuantityException extends ValidationRuntimeException {

    public InsufficientQuantityException(int maxQty) {
        super("Insufficient productItem quantity. Available quantity : " + maxQty);
    }
}
