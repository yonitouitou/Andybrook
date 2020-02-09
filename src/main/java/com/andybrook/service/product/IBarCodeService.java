package com.andybrook.service.product;

import com.andybrook.model.BarCode;

public interface IBarCodeService {

    void newBarCode(BarCode barCode);

    BarCode get(BarCode barCode);

    boolean isBarCodeExist(BarCode barCode);
}
