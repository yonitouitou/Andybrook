package com.andybrook.service.stock;

import com.andybrook.exception.*;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;

import java.util.Map;

public interface IOrderItemService {

    StockItem<? extends Product> newOrderItem(long stockReportId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed;

    StockItem<? extends Product> updateOrderItem(long stockReportId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed;

    StockItem<? extends Product> getOrderItem(long id) throws OrderItemNotFound;

    Map<Long, StockItem<? extends Product>> getOrderItems();

    boolean deleteOrderItem(long id);

    StockItem<? extends Product> incrementQuantity(long orderId, long itemId) throws OrderItemNotFound, OrderNotFound;

    StockItem<? extends Product> incrementQuantityOrCreate(long orderId, StockItem<? extends Product> item) throws OrderNotFound, OrderClosed;

    StockItem<? extends Product> getOrderItemByBarCode(String barCodeId) throws BarCodeNotFound;
}
