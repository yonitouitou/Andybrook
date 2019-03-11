package com.andybrook.manager.stock;

import com.andybrook.exception.*;
import com.andybrook.model.BarCode;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;
import com.andybrook.service.stock.IStockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class StockItemManager implements IStockItemManager {

    private static final String GLASSES_STOCK_ITEM_ERROR = "tockItem must not be null";

    @Autowired
    private IStockItemService stockItemService;

    @Override
    public StockItem<? extends Product> updateStockItem(long orderId, StockItem<? extends Product> item) throws OrderNotFound, OrderClosed {
        Objects.requireNonNull(item, GLASSES_STOCK_ITEM_ERROR);
        return isNewGlassesCreated(item)
                ? stockItemService.newStockItem(orderId, item)
                : stockItemService.updateStockItem(orderId, item);
    }

    @Override
    public StockItem<? extends Product> incrementQuantityOrCreate(long orderId, StockItem<? extends Product> item) throws OrderClosed, OrderNotFound {
        return stockItemService.incrementQuantityOrCreate(orderId, item);
    }

    @Override
    public StockItem<? extends Product> getStockItem(long id) throws StockItemNotFound {
        return stockItemService.getStockItem(id);
    }

    @Override
    public Map<Long, StockItem<? extends Product>> getAllStockItems() {
        return stockItemService.getAllStockItems();
    }

    @Override
    public boolean removeStockItem(long id) {
        return stockItemService.removeStockItem(id);
    }

    @Override
    public StockItem<? extends Product> getStockItemByBarCode(String barCodeId) throws BarCodeNotFound {
        return stockItemService.getStockItemByBarCode(barCodeId);
    }

    private boolean isNewGlassesCreated(StockItem<? extends Product> item) {
        return item.getId() == null;
    }
}
