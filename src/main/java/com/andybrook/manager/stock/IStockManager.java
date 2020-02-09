package com.andybrook.manager.stock;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;

import java.util.List;

public interface IStockManager {

    ProductStockInfo getProductStockInfo(ProductId productId);

    ProductItem getProductItemByBarCodeId(BarCode barCode);

    List<ProductStockInfo> getAllProductNamesWithQuantityMoreThan(int quantity);
}
