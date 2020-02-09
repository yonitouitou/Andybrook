package com.andybrook.service.stock;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;

import java.util.List;
import java.util.Optional;

public interface IStockService {

    void addProductItem(ProductItem productItem);

    ProductItem getProductItem(long productItemId);

    double getPrice(ProductItem productItem);

    ProductItem getProductItemByBarCode(BarCode barCode);

    void onProductItemLinked(ProductItem productItem);

    void onProductItemUnlinked(ProductItem productItem);

    ProductStockInfo getProductStockInfo(ProductId productId);

    int getFreeQuantity(ProductId productId);

    void decrementQuantityUsed(ProductId productId);

    Optional<ProductItem> findFreeProductItemOf(ProductId productId);

    List<ProductStockInfo> getAllProductNamesWithQuantityMoreThan(int quantity);

    int getProductItemSizeOfProduct(ProductId productId);
}
