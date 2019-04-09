package com.andybrook.service.product;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;

public interface IBarCodeService {

    void newBarCode(Product product, BarCode barCode);

    BarCode get(String id);

    Product getProduct(String barCodeId);

    boolean isBarCodeExist(String barCodeId);
}
