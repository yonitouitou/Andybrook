package com.andybrook.manager.stock;

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
    public List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return stockService.getAllProductNamesWithQuantityMoreThan(quantity);
    }
}
