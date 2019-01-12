package com.andybrook.dao.stock;

import com.andybrook.model.GlassesStockItem;

import java.util.Optional;

public interface IGlassesStockDao {

    Optional<GlassesStockItem> getGlassesStockItem(long id);

    GlassesStockItem updateGlassesStockItem(GlassesStockItem item);

    boolean removeGlassesStockItem(long id);
}
