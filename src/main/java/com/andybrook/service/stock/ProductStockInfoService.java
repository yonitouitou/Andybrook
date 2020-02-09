package com.andybrook.service.stock;

import com.andybrook.dao.product.IProductStockInfoDao;
import com.andybrook.exception.ValidationRuntimeException;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductStockInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ProductStockInfoService implements IProductStockInfoService {

    @Autowired
    private IProductStockInfoDao dao;

    @Override
    public void add(ProductId productId) {
        dao.save(new ProductStockInfo(productId, 0, 0));
    }

    @Override
    public List<ProductStockInfo> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return dao.getAllProductNamesWithQuantityMoreThan(quantity);
    }

    @Override
    public int getFreeQuantity(ProductId productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityUnused();
    }

    @Override
    public int getCreatedQuantity(ProductId productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityCreated();
    }

    @Override
    public int getUsedQuantity(ProductId productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityUsed();
    }

    @Override
    public boolean isFreeQuantityExist(ProductId productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityUnused() > 0;
    }

    @Override
    public void incrementQuantityUsed(ProductId productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.incrementQuantityUsed();
        dao.save(productStockInfo);
    }

    @Override
    public void incrementQuantityCreated(ProductId productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.incrementQuantityCreated();
        dao.save(productStockInfo);
    }

    @Override
    public void decrementQuantityUsed(ProductId productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.decrementQuantityUsed();
        dao.save(productStockInfo);
    }

    @Override
    public void decrementQuantityCreated(ProductId productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.decrementQuantityCreated();
        dao.save(productStockInfo);
    }

    @Override
    public ProductStockInfo get(ProductId productId) {
        Optional<ProductStockInfo> stockInfoOpt = dao.get(productId);
        return stockInfoOpt.orElseThrow(() -> new ProductStockInfoNotFound(productId));
    }

    private class ProductStockInfoNotFound extends ValidationRuntimeException {

        private ProductStockInfoNotFound(ProductId productId) {
            super("Product Stock Info not found for product " + productId.get());
        }
    }
}
