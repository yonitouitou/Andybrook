package com.andybrook.model;

public class BarCode {

    private final String id;

    public BarCode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BarCode{" +
                "id='" + id + '\'' +
                '}';
    }
}

