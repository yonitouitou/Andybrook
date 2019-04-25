package com.andybrook.dao.stock;

import com.andybrook.model.stock.ProductItem;

import java.util.Optional;

public interface IProductItemDao {

    ProductItem update(ProductItem productItem);

    ProductItem delete(long id);

    Optional<ProductItem> find(long id);
}
