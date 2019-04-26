package com.andybrook.service.stock;

import com.andybrook.dao.stock.IProductStockInfoDao;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductStockInfo;
import com.andybrook.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductStockInfoService implements IProductStockInfoService {

    @Autowired
    private IProductStockInfoDao dao;
    @Autowired
    private IProductService productService;

    @Override
    public void add(long productId) {
        Product product = productService.get(productId);
        dao.update(new ProductStockInfo(product, 0, 0));
    }

    @Override
    public List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return dao.getAllProductNamesWithQuantityMoreThan(quantity);
    }

    @Override
    public int getFreeQuantity(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityUnused();
    }

    @Override
    public int getCreatedQuantity(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityCreated();
    }

    @Override
    public int getUsedQuantity(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityUsed();
    }

    @Override
    public boolean isFreeQuantityExist(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityUnused() > 0;
    }

    @Override
    public void incrementQuantityUsed(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.incrementQuantityUsed();
        dao.update(productStockInfo);
    }

    @Override
    public void incrementQuantityCreated(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.incrementQuantityCreated();
        dao.update(productStockInfo);
    }

    @Override
    public void decrementQuantityUsed(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.decrementQuantityUsed();
        dao.update(productStockInfo);
    }

    @Override
    public void decrementQuantityCreated(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.decrementQuantityCreated();
        dao.update(productStockInfo);
    }

    ProductStockInfo get(long productId) {
        return dao.get(productId);
    }
}
