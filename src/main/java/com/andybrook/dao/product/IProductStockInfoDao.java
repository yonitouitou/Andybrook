package com.andybrook.dao.product;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

public interface IProductStockInfoDao {

    void save(ProductStockInfo productStockInfo);

    Optional<ProductStockInfo> get(ProductId productId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);


}
