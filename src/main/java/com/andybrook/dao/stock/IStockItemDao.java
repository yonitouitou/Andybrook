package com.andybrook.dao.stock;

import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;

import java.util.Map;
import java.util.Optional;

public interface IStockItemDao{

    <T extends Product> Optional<StockItem<T>> getStockItem(long id);

    <T extends Product> StockItem<T> updateStockItem(long stockReportId, StockItem<T> item);

    <T extends Product> Map<Long, StockItem<T>> getAllStockItems();

    boolean removeStockItem(long id);
}
