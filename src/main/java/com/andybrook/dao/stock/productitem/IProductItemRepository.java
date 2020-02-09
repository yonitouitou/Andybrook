package com.andybrook.dao.stock.productitem;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import java.util.Optional;

public interface IProductItemRepository {

    void save(ProductItem productItem);

    Optional<ProductItem> get(long id);

    boolean delete(long id);

    int countByProductId(ProductId id);
}
