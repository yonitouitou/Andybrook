package com.andybrook.service.stock;

import com.andybrook.exception.*;
import com.andybrook.model.BarCode;
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

    StockItem<? extends Product> incrementQuantityOrCreate(long orderId, StockItem<? extends Product> item) throws OrderNotFound, OrderClosed;

    StockItem<? extends Product> getStockItemByBarCode(String barCodeId) throws BarCodeNotFound;
}
