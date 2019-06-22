package com.andybrook.exception;

import com.andybrook.enums.FileFormat;

public class UnsupportedFormatFile extends RuntimeException {

    public UnsupportedFormatFile(FileFormat format) {
        super(format.name());
    }
}
