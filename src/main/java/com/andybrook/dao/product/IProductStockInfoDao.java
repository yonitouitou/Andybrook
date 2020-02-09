package com.andybrook.dao.product;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductStockInfo;

import java.util.List;
import java.util.Optional;

public interface IProductStockInfoDao {

    void save(ProductStockInfo productStockInfo);

    Optional<ProductStockInfo> get(ProductId productId);

    List<ProductStockInfo> getAllProductNamesWithQuantityMoreThan(int quantity);


}
