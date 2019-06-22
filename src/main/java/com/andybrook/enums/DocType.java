package com.andybrook.enums;

public enum DocType {

    ORDER_FORM("ORDER_FORM", new FileFormat[] {FileFormat.CSV, FileFormat.PDF});

    String name;
    FileFormat[] supportedFormat;

    DocType(String name, FileFormat[] supportedFormat) {
        this.name = name;
        this.supportedFormat = supportedFormat;
    }

    public String getName() {
        return name;
    }

    public FileFormat[] getSupportedFormat() {
        return supportedFormat;
    }
}
