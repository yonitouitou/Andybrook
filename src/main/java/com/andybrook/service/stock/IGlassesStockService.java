package com.andybrook.service.stock;

import com.andybrook.model.GlassesStockItem;

public interface IGlassesStockService {

    GlassesStockItem newGlassesStockItem(GlassesStockItem item);

    GlassesStockItem updateGlassesStockItem(GlassesStockItem item);
}
