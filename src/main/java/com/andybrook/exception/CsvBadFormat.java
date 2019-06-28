package com.andybrook.exception;

public class CsvBadFormat extends Exception {

    public CsvBadFormat(String line) {
        super(line);
    }
}
