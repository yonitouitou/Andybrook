package com.andybrook.manager.stock;

import com.andybrook.exception.StockItemNotFound;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;

import java.util.Map;

public interface IStockItemManager {

    StockItem<? extends Product> getStockItem(long id) throws StockItemNotFound;

    Map<Long, StockItem<? extends Product>> getAllStockItems();

    StockItem<? extends Product> updateStockItem(long orderId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed;

    boolean removeStockItem(long id);

    StockItem<? extends Product> incrementQuantity(long orderId, long itemId) throws StockItemNotFound, OrderNotFound;
}
