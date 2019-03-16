package com.andybrook.manager.stock;

import com.andybrook.exception.*;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;
import com.andybrook.service.stock.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class OrderItemManager implements IOrderItemManager {

    private static final String GLASSES_STOCK_ITEM_ERROR = "tockItem must not be null";

    @Autowired
    private IOrderItemService stockItemService;

    @Override
    public StockItem<? extends Product> updateStockItem(long orderId, StockItem<? extends Product> item) throws OrderNotFound, OrderClosed {
        Objects.requireNonNull(item, GLASSES_STOCK_ITEM_ERROR);
        return isNewGlassesCreated(item)
                ? stockItemService.newOrderItem(orderId, item)
                : stockItemService.updateOrderItem(orderId, item);
    }

    @Override
    public StockItem<? extends Product> incrementQuantityOrCreate(long orderId, StockItem<? extends Product> item) throws OrderClosed, OrderNotFound {
        return stockItemService.incrementQuantityOrCreate(orderId, item);
    }

    @Override
    public StockItem<? extends Product> getStockItem(long id) throws OrderItemNotFound {
        return stockItemService.getOrderItem(id);
    }

    @Override
    public Map<Long, StockItem<? extends Product>> getAllStockItems() {
        return stockItemService.getOrderItems();
    }

    @Override
    public boolean removeStockItem(long id) {
        return stockItemService.deleteOrderItem(id);
    }

    @Override
    public StockItem<? extends Product> getStockItemByBarCode(String barCodeId) throws BarCodeNotFound {
        return stockItemService.getOrderItemByBarCode(barCodeId);
    }

    private boolean isNewGlassesCreated(StockItem<? extends Product> item) {
        return item.getId() == null;
    }
}
