package com.andybrook.generator;

import com.andybrook.model.BarCode;
import com.andybrook.util.IdGenerator;

public final class BarCodeGenerator {

    public static final BarCode generateBarCode() {
        return new BarCode(IdGenerator.generateAlfaNumericId());
    }

}
