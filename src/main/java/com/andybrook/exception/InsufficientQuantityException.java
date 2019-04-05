package com.andybrook.exception;

public class InsufficientQuantityException extends Exception {

    public InsufficientQuantityException(int maxQty) {
        super("Insufficient quantity. Max quantity allowed : " + maxQty);
    }
}
