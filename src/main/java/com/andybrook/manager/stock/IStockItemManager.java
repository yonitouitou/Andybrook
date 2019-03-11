package com.andybrook.manager.stock;

import com.andybrook.exception.*;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;

import java.util.Map;

public interface IStockItemManager {

    StockItem<? extends Product> getStockItem(long id) throws StockItemNotFound;

    Map<Long, StockItem<? extends Product>> getAllStockItems();

    StockItem<? extends Product> updateStockItem(long orderId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed;

    boolean removeStockItem(long id);

    StockItem<? extends Product> incrementQuantityOrCreate(long orderId, StockItem<? extends Product> item) throws OrderClosed, OrderNotFound;

    StockItem<? extends Product> getStockItemByBarCode(String barCodeId) throws BarCodeNotFound;
}
