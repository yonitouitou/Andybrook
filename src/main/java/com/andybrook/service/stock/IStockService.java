package com.andybrook.service.stock;

import com.andybrook.model.stock.ProductItem;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IStockService {

    ProductItem addProductItem(ProductItem productItem);

    ProductItem getProductItem(long productItemId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);
}
