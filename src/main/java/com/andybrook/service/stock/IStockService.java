package com.andybrook.service.stock;

import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

public interface IStockService {

    void addProductItem(ProductItem productItem);

    ProductItem getProductItem(long productItemId);

    ProductItem getProductItemByBarCode(String barCodeId);

    void onProductItemLinked(ProductItem productItem);

    void onProductItemUnlinked(ProductItem productItem);

    ProductStockInfo getProductStockInfo(long productId);

    ProductItem getProductItemByBarCodeId(String barCodeId);

    int getFreeQuantity(long productId);

    void decrementQuantityUsed(long productId);

    Optional<ProductItem> findFreeProductItemOf(long productId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);

    int getProductItemSizeOfProduct(long productId);
}
