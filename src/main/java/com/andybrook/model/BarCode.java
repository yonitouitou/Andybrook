package com.andybrook.model;

import java.util.UUID;

public class BarCode {

    private final String id;

    public BarCode() {
        id = UUID.randomUUID().toString();
    }

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

