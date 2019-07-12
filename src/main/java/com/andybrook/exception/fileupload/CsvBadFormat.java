package com.andybrook.exception.fileupload;

public class CsvBadFormat extends Exception {

    public CsvBadFormat(String line) {
        super(line);
    }
}
