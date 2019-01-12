package com.andybrook.manager.stock;

import com.andybrook.model.GlassesStockItem;

import java.util.Map;
import java.util.Optional;

public interface IGlassesStockManager {

    Optional<GlassesStockItem> getGlassesStockItem(long id);

    Map<Long, GlassesStockItem> getAllGlassesStockItems();

    GlassesStockItem updateGlassesStock(GlassesStockItem item);

    boolean removeGlassesStock(long id);
}
