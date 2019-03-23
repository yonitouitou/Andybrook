package com.andybrook.service.product;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;

public interface IBarCodeService {

    void newBarCode(Product product, BarCode barCode);

    long getStockItemIdByBarCodeId(String id);

    boolean isBarCodeExist(BarCode barCode);
}
