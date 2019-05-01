package com.andybrook.service.stock;

import com.andybrook.model.stock.ProductItem;

import java.util.Optional;

interface IProductItemService {

    void add(ProductItem productItem);

    ProductItem get(long productItemId);

    int getProductItemSize(long productId);

    void update(ProductItem productItem);

    Optional<ProductItem> findFreeProductItemOf(long productId);
}
