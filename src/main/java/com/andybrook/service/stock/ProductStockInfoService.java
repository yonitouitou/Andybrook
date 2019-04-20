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
public class ProductStockInfoService implements IProductStockInfoService {

    @Autowired
    private IProductStockInfoDao dao;
    @Autowired
    private IProductService productService;

    @Override
    public void update(long productId, int quantityCreated, int quantityUsed) {
        Product product = productService.get(productId);
        dao.add(new ProductStockInfo(product, quantityCreated, quantityUsed));
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
    public boolean isFreeQuantityExist(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        return productStockInfo.getQuantityUnused() > 0;
    }

    @Override
    public void incrementQuantityUsed(long productId) {
        ProductStockInfo productStockInfo = get(productId);
        productStockInfo.incrementQuantityUsed();
    }

    private ProductStockInfo get(long productId) {
        return dao.get(productId);
    }
}
