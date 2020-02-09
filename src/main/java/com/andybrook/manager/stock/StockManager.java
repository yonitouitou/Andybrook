package com.andybrook.manager.stock;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;
import com.andybrook.service.stock.IStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockManager implements IStockManager {

    @Autowired
    private IStockService stockService;

    @Override
    public ProductStockInfo getProductStockInfo(ProductId productId) {
        return stockService.getProductStockInfo(productId);
    }

    @Override
    public ProductItem getProductItemByBarCodeId(BarCode barCode) {
        return stockService.getProductItemByBarCode(barCode);
    }

    @Override
    public List<ProductStockInfo> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return stockService.getAllProductNamesWithQuantityMoreThan(quantity);
    }
}
