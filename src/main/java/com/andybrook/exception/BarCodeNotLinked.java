package com.andybrook.exception;

import com.andybrook.model.BarCode;

public class BarCodeNotLinked extends ValidationRuntimeException {

    public BarCodeNotLinked(BarCode barCode) {
        super("BarCode " + barCode.get() + " is not linked to a productItem");
    }
}
