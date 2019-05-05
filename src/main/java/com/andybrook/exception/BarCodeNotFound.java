package com.andybrook.exception;

public class BarCodeNotFound extends ValidationRuntimeException {

    public BarCodeNotFound(String barCodeId) {
        super(String.valueOf(barCodeId));
    }
}
