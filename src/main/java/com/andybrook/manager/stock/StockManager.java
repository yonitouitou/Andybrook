package com.andybrook.manager.stock;

import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;
import com.andybrook.service.stock.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockManager implements IStockManager {

    @Autowired
    private IStockService stockService;

    @Override
    public ProductStockInfo getProductStockInfo(long productId) {
        return stockService.getProductStockInfo(productId);
    }

    @Override
    public ProductItem getProductItemByBarCodeId(String barCodeId) {
        return stockService.getProductItemByBarCodeId(barCodeId);
    }

    @Override
    public List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return stockService.getAllProductNamesWithQuantityMoreThan(quantity);
    }
}
