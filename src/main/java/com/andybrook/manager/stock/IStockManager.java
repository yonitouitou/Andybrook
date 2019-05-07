package com.andybrook.manager.stock;

import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IStockManager {

    ProductStockInfo getProductStockInfo(long productId);

    ProductItem getProductItemByBarCodeId(String barCodeId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);
}
