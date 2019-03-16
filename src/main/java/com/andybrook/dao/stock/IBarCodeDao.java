package com.andybrook.dao.stock;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;

import java.util.Optional;

public interface IBarCodeDao {

    boolean isExist(String id);

    BarCode save(Product product, BarCode barCode);

    Optional<BarCode> get(String id);

    long getStockItemIdByBarCodeId(String id);
}
