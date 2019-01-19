package com.andybrook.service.stock;

import com.andybrook.model.Product;
import com.andybrook.model.StockItem;

import java.util.Map;
import java.util.Optional;

public interface IStockItemService {

    StockItem<? extends Product> newStockItem(long stockReportId, StockItem<? extends Product> item);

    StockItem<? extends Product> updateStockItem(long stockReportId, StockItem<? extends Product> item);

    Optional<StockItem<? extends Product>> getStockItem(long id);

    Map<Long, StockItem<? extends Product>> getAllStockItems();

    boolean removeStockItem(long id);
}
