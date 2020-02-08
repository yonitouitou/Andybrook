package com.andybrook.dao.stock.barcode;

import com.andybrook.model.BarCode;

import java.util.Optional;

public interface IBarCodeDao {

    boolean isExist(String id);

    void save(BarCode barCode);

    Optional<BarCode> get(String id);
}
