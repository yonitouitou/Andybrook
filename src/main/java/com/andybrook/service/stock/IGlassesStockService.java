package com.andybrook.service.stock;

import com.andybrook.model.GlassesStockItem;

import java.util.Map;
import java.util.Optional;

public interface IGlassesStockService {

    GlassesStockItem newGlassesStockItem(GlassesStockItem item);

    GlassesStockItem updateGlassesStockItem(GlassesStockItem item);

    Optional<GlassesStockItem> getGlassesStockItem(long id);

    Map<Long, GlassesStockItem> getAllGlassesStockItems();

    boolean removeGlassesStockItem(long id);
}
