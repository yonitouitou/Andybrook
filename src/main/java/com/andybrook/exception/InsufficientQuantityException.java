package com.andybrook.exception;

public class InsufficientQuantityException extends ValidationRuntimeException {

    public InsufficientQuantityException(int maxQty) {
        super("Insufficient product quantity. Available quantity : " + maxQty);
    }
}
