package com.andybrook.dao.stock.barcode;

import com.andybrook.model.BarCode;

import java.util.Optional;

public interface IBarCodeDao {

    boolean isExist(BarCode barCode);

    void save(BarCode barCode);

    Optional<BarCode> get(BarCode barCode);
}
