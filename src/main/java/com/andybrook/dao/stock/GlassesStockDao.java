package com.andybrook.dao.stock;

import com.andybrook.dao.stock.jpa.GlassesStockItemEntity;
import com.andybrook.dao.stock.jpa.IGlassesStockCrudRepository;
import com.andybrook.model.GlassesStockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GlassesStockDao implements IGlassesStockDao {

    @Autowired
    private IGlassesStockCrudRepository glassesStockCrudRepository;

    @Override
    public Optional<GlassesStockItem> getGlassesStockItem(long id) {
        Optional<GlassesStockItem> glassesStockItemOpt = Optional.empty();
        Optional<GlassesStockItemEntity> entityOpt = glassesStockCrudRepository.findById(id);
        if (entityOpt.isPresent()) {
            GlassesStockItemEntity entity = entityOpt.get();
            GlassesStockItem glassesStockItem = GlassesStockItemEntity.toModel(entity);
            glassesStockItemOpt = Optional.of(glassesStockItem);
        }
        return glassesStockItemOpt;
    }

    @Override
    public GlassesStockItem updateGlassesStockItem(GlassesStockItem item) {
        GlassesStockItemEntity entity = GlassesStockItemEntity.toEntity(item);
        GlassesStockItemEntity entitySaved = glassesStockCrudRepository.save(entity);
        item.setId(entitySaved.getId());
        return item;
    }

    @Override
    public Map<Long, GlassesStockItem> getAllGlassesStockItems() {
        Map<Long, GlassesStockItem> itemsMapById = new HashMap<>();
        Iterable<GlassesStockItemEntity> entities = glassesStockCrudRepository.findAll();
        entities.forEach(e -> {
            GlassesStockItem glassesStockItem = GlassesStockItemEntity.toModel(e);
            itemsMapById.put(glassesStockItem.getId(), glassesStockItem);
        });
        return itemsMapById;
    }

    @Override
    public boolean removeGlassesStockItem(long id) {
        glassesStockCrudRepository.deleteById(id);
        return true;
    }
}
