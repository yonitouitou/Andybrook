package com.andybrook.exception;

public class BarCodeAlreadyExist extends ValidationRuntimeException {

    public BarCodeAlreadyExist(String id) {
        super("Bar code with id " + id + " already exist");
    }
}
