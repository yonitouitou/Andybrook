package com.andybrook.service.stock;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductStockInfo;

import java.util.List;

public interface IProductStockInfoService {

    void add(ProductId productId);

    ProductStockInfo get(ProductId productId);

    List<ProductStockInfo> getAllProductNamesWithQuantityMoreThan(int quantity);

    int getFreeQuantity(ProductId productId);

    int getCreatedQuantity(ProductId productId);

    int getUsedQuantity(ProductId productId);

    boolean isFreeQuantityExist(ProductId productId);

    void incrementQuantityUsed(ProductId productId);

    void incrementQuantityCreated(ProductId productId);

    void decrementQuantityUsed(ProductId productId);

    void decrementQuantityCreated(ProductId productId);
}
