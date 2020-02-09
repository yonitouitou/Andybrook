package com.andybrook.exception;

import com.andybrook.model.BarCode;

public class BarCodeNotFound extends ValidationRuntimeException {

    public BarCodeNotFound(BarCode barCode) {
        super(barCode.get());
    }
}
