package com.andybrook.service.stock;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import java.util.Optional;

interface IProductItemService {

    void add(ProductItem productItem);

    ProductItem get(long productItemId);

    ProductItem getByBarCodeId(String barCodeId);

    int getProductItemSize(ProductId productId);

    void update(ProductItem productItem);

    Optional<ProductItem> findFreeProductItemOf(ProductId productId);

    double getPrice(ProductItem productItem);
}
