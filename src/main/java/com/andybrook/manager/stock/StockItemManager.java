package com.andybrook.manager.stock;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import com.andybrook.service.stock.IStockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class StockItemManager implements IStockItemManager {

    private static final String GLASSES_STOCK_ITEM_ERROR = "GlassesStockItem must not be null";

    @Autowired
    private IStockItemService glassesStockService;

    @Override
    public StockItem<? extends Product> updateStockItem(long stockReportId, StockItem<? extends Product> item) throws StockReportNotFound, StockReportClosed {
        Objects.requireNonNull(item, GLASSES_STOCK_ITEM_ERROR);
        return isNewGlassesCreated(item.getProduct())
                ? glassesStockService.newStockItem(stockReportId, item)
                : glassesStockService.updateStockItem(stockReportId, item);
    }

    @Override
    public Optional<StockItem<? extends Product>> getStockItem(long id) {
        return glassesStockService.getStockItem(id);
    }

    @Override
    public Map<Long, StockItem<? extends Product>> getAllStockItems() {
        return glassesStockService.getAllStockItems();
    }

    @Override
    public boolean removeStockItem(long id) {
        return glassesStockService.removeStockItem(id);
    }

    private boolean isNewGlassesCreated(Product product) {
        return product.getId() == null;
    }
}
