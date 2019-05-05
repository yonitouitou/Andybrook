package com.andybrook.dao.stock;

import com.andybrook.model.stock.ProductItem;

import java.util.Optional;

public interface IProductItemDao {

    void update(ProductItem productItem);

    ProductItem delete(long id);

    int getProductItemSize(long productId);

    Optional<ProductItem> find(long id);

    Optional<ProductItem> findByBarCodeId(String barCodeId);

    Optional<ProductItem> findFreeProductItemOf(long productId);
}
