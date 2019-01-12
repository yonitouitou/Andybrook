package com.andybrook.manager.stock;

import com.andybrook.model.GlassesStockItem;

public interface IGlassesStockManager {

    GlassesStockItem updateGlassesStock(GlassesStockItem item);

    boolean removeGlassesStock(long id);
}
