package com.andybrook.service.stock;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;

import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

public interface IStockService {

    void addProductItem(ProductItem productItem);

    ProductItem getProductItem(long productItemId);

    double getPrice(ProductItem productItem);

    ProductItem getProductItemByBarCode(String barCodeId);

    void onProductItemLinked(ProductItem productItem);

    void onProductItemUnlinked(ProductItem productItem);

    ProductStockInfo getProductStockInfo(ProductId productId);

    ProductItem getProductItemByBarCodeId(String barCodeId);

    int getFreeQuantity(ProductId productId);

    void decrementQuantityUsed(ProductId productId);

    Optional<ProductItem> findFreeProductItemOf(ProductId productId);

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);

    int getProductItemSizeOfProduct(ProductId productId);
}
