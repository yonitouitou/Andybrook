package com.andybrook.service.stock;

import com.andybrook.model.stock.ProductItem;

import java.util.Optional;

interface IProductItemService {

    ProductItem add(ProductItem productItem);

    ProductItem get(long productItemId);

    ProductItem update(ProductItem productItem);

    Optional<ProductItem> findFreeProductItemOf(long productId);
}
