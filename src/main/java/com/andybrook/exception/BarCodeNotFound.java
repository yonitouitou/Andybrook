package com.andybrook.exception;

public class BarCodeNotFound extends ValidationRuntimeException {

    public BarCodeNotFound(String barCodeId) {
        super("Bar code with id " + barCodeId + " not found");
    }
}
