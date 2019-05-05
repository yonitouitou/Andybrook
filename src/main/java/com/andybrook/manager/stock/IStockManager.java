package com.andybrook.manager.stock;

import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IStockManager {

    ProductStockInfo getProductStockInfo(long productId);

    ProductStockInfo getProductStockInfoByBarCodeId(String barCodeId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);
}
