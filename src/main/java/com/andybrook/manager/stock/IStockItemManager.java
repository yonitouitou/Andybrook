package com.andybrook.manager.stock;

import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.Product;
import com.andybrook.model.StockItem;

import java.util.Map;
import java.util.Optional;

public interface IStockItemManager {

    Optional<StockItem<? extends Product>> getStockItem(long id);

    Map<Long, StockItem<? extends Product>> getAllStockItems();

    StockItem<? extends Product> updateStockItem(long stockReportId, StockItem<? extends Product> item) throws StockReportNotFound;

    boolean removeStockItem(long id);
}
