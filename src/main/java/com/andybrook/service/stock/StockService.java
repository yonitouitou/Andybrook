package com.andybrook.service.stock;

import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;
import com.andybrook.service.product.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService implements IStockService {

    @Autowired
    private IProductStockInfoService productStockInfoService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductItemService productItemService;

    @Override
    public void addProductItem(ProductItem productItem) {
        ProductId productId = productItem.getProductId();
        if (! productService.isExist(productId)) {
            throw new ProductNotFound(productId);
        }
        productItemService.add(productItem);
        productStockInfoService.incrementQuantityCreated(productId);
    }

    @Override
    public ProductItem getProductItem(long productItemId) {
        return productItemService.get(productItemId);
    }

    @Override
    public double getPrice(ProductItem productItem) {
        return productItemService.getPrice(productItem);
    }

    @Override
    public ProductItem getProductItemByBarCode(BarCode barCode) {
        return productItemService.getByBarCode(barCode);
    }

    @Override
    public ProductStockInfo getProductStockInfo(ProductId productId) {
        return productStockInfoService.get(productId);
    }

    @Override
    public void onProductItemLinked(ProductItem productItem) {
        productItemService.update(productItem);
        productStockInfoService.incrementQuantityUsed(productItem.getProductId());
    }

    @Override
    public void onProductItemUnlinked(ProductItem productItem) {
        productItemService.update(productItem);
        productStockInfoService.decrementQuantityUsed(productItem.getProductId());
    }

    @Override
    public int getFreeQuantity(ProductId productId) {
        return productStockInfoService.getFreeQuantity(productId);
    }

    @Override
    public void decrementQuantityUsed(ProductId productId) {
        productStockInfoService.decrementQuantityUsed(productId);
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(ProductId productId) {
        return productItemService.findFreeProductItemOf(productId);
    }

    @Override
    public List<ProductStockInfo> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return productStockInfoService.getAllProductNamesWithQuantityMoreThan(quantity);
    }

    @Override
    public int getProductItemSizeOfProduct(ProductId productId) {
        return productItemService.getProductItemSize(productId);
    }
}
