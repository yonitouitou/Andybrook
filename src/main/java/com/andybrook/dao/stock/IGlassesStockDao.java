package com.andybrook.dao.stock;

import com.andybrook.model.GlassesStockItem;

import java.util.Map;
import java.util.Optional;

public interface IGlassesStockDao {

    Optional<GlassesStockItem> getGlassesStockItem(long id);

    GlassesStockItem updateGlassesStockItem(GlassesStockItem item);

    Map<Long, GlassesStockItem> getAllGlassesStockItems();

    boolean removeGlassesStockItem(long id);
}
