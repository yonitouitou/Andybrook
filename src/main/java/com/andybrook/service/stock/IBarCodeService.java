package com.andybrook.service.stock;

import com.andybrook.model.BarCode;

public interface IBarCodeService {

    long getStockItemIdByBarCodeId(String id);

    boolean isBarCodeExist(BarCode barCode);
}
