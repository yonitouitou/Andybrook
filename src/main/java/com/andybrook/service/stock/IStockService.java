package com.andybrook.service.stock;

import com.andybrook.model.stock.ProductItem;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

public interface IStockService {

    ProductItem addProductItem(ProductItem productItem);

    ProductItem getProductItem(long productItemId);

    ProductItem updateProductItem(ProductItem productItem);

    Optional<ProductItem> findFreeProductItemOf(long productId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);
}
