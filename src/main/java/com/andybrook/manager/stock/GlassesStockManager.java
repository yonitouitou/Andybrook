package com.andybrook.manager.stock;

import com.andybrook.model.Glasses;
import com.andybrook.model.GlassesStockItem;
import com.andybrook.service.stock.IGlassesStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GlassesStockManager implements IGlassesStockManager {

    private static final String GLASSES_STOCK_ITEM_ERROR = "GlassesStockItem must not be null";

    @Autowired
    private IGlassesStockService glassesStockService;

    @Override
    public GlassesStockItem updateGlassesStock(GlassesStockItem item) {
        Objects.requireNonNull(item, GLASSES_STOCK_ITEM_ERROR);
        return isNewGlassesCreated(item.getGlasses())
                ? glassesStockService.newGlassesStockItem(item)
                : glassesStockService.updateGlassesStockItem(item);
    }

    @Override
    public boolean removeGlassesStock(long id) {
        return glassesStockService.removeGlassesStockItem(id);
    }

    private boolean isNewGlassesCreated(Glasses glasses) {
        return glasses.getId() == null;
    }
}
