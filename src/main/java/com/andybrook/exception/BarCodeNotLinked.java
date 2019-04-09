package com.andybrook.exception;

public class BarCodeNotLinked extends ValidationRuntimeException {

    public BarCodeNotLinked(String id) {
        super("BarCode " + id + " is not linked to a product");
    }
}
