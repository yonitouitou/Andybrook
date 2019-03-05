package com.andybrook.manager.stock;

import com.andybrook.exception.StockItemNotFound;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import com.andybrook.service.stock.IStockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class StockItemManager implements IStockItemManager {

    private static final String GLASSES_STOCK_ITEM_ERROR = "GlassesStockItem must not be null";

    @Autowired
    private IStockItemService stockItemService;

    @Override
    public StockItem<? extends Product> updateStockItem(long orderId, StockItem<? extends Product> item) throws OrderNotFound, OrderClosed {
        Objects.requireNonNull(item, GLASSES_STOCK_ITEM_ERROR);
        return isNewGlassesCreated(item.getProduct())
                ? stockItemService.newStockItem(orderId, item)
                : stockItemService.updateStockItem(orderId, item);
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
    public StockItem<? extends Product> incrementQuantity(long orderId, long itemId) throws StockItemNotFound, OrderNotFound {
        return stockItemService.incrementQuantity(orderId, itemId);
    }

    private boolean isNewGlassesCreated(Product product) {
        return product.getId() == null;
    }
}
