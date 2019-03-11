package com.andybrook.exception;

public class BarCodeAlreadyExist extends Exception {

    public BarCodeAlreadyExist(String id) {
        super("Bar code with id " + id + " already exist");
    }
}
