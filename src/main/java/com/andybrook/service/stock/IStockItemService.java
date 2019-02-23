package com.andybrook.service.stock;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;

import java.util.Map;
import java.util.Optional;

public interface IStockItemService {

    StockItem<? extends Product> newStockItem(long stockReportId, StockItem<? extends Product> item)
            throws OrderNotFound, StockReportClosed;

    StockItem<? extends Product> updateStockItem(long stockReportId, StockItem<? extends Product> item)
            throws OrderNotFound, StockReportClosed;

    Optional<StockItem<? extends Product>> getStockItem(long id);

    Map<Long, StockItem<? extends Product>> getAllStockItems();

    boolean removeStockItem(long id);
}
