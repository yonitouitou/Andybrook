package com.andybrook.dao.stock;

import com.andybrook.dao.glasses.IGlassesDao;
import com.andybrook.dao.stock.jpa.GlassesStockItemEntity;
import com.andybrook.dao.stock.jpa.IGlassesStockCrudRepository;
import com.andybrook.model.GlassesStockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlassesStockDao implements IGlassesStockDao {

    @Autowired
    private IGlassesStockCrudRepository glassesStockCrudRepository;
    @Autowired
    private IGlassesDao glassesDao;

    @Override
    public GlassesStockItem updateGlassesStockItem(GlassesStockItem item) {
        GlassesStockItemEntity entity = GlassesStockItemEntity.newInstance(item);
        GlassesStockItemEntity entitySaved = glassesStockCrudRepository.save(entity);
        item.setId(entitySaved.getId());
        return item;
    }
}
