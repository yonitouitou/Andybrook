package com.andybrook.enums;

public enum DocType {

    ORDER_FORM("ORDER_FORM");

    String name;

    DocType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
