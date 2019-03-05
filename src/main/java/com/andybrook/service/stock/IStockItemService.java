package com.andybrook.service.stock;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StockItemNotFound;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;

import java.util.Map;

public interface IStockItemService {

    StockItem<? extends Product> newStockItem(long stockReportId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed;

    StockItem<? extends Product> updateStockItem(long stockReportId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed;

    StockItem<? extends Product> getStockItem(long id) throws StockItemNotFound;

    Map<Long, StockItem<? extends Product>> getAllStockItems();

    boolean removeStockItem(long id);

    StockItem<? extends Product> incrementQuantity(long orderId, long itemId) throws StockItemNotFound, OrderNotFound;
}
