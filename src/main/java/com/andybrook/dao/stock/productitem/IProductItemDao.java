package com.andybrook.dao.stock.productitem;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import java.util.Optional;

public interface IProductItemDao {

    void save(ProductItem productItem);

    Optional<ProductItem> get(long id);

    boolean delete(long id);

    int getProductItemSize(ProductId productId);

    Optional<ProductItem> findByBarCodeId(String barCodeId);

    Optional<ProductItem> findFreeProductItemOf(ProductId productId);
}
