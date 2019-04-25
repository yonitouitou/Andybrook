package com.andybrook.dao.stock;

import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IProductStockInfoDao {

    ProductStockInfo update(ProductStockInfo productStockInfo);

    ProductStockInfo get(long productId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);


}
