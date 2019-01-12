package com.andybrook.dao.stock;

import com.andybrook.dao.glasses.IGlassesDao;
import com.andybrook.dao.stock.jpa.GlassesStockItemEntity;
import com.andybrook.dao.stock.jpa.IGlassesStockCrudRepository;
import com.andybrook.model.Glasses;
import com.andybrook.model.GlassesStockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GlassesStockDao implements IGlassesStockDao {

    @Autowired
    private IGlassesStockCrudRepository glassesStockCrudRepository;
    @Autowired
    private IGlassesDao glassesDao;

    @Override
    public Optional<GlassesStockItem> getGlassesStockItem(long id) {
        Optional<GlassesStockItem> glassesStockItemOpt = Optional.empty();
        Optional<GlassesStockItemEntity> entityOpt = glassesStockCrudRepository.findById(id);
        if (entityOpt.isPresent()) {
            GlassesStockItemEntity entity = entityOpt.get();
            Optional<Glasses> glassesOpt = glassesDao.getGlasses(entity.getGlassesId());
            if (glassesOpt.isPresent()) {
                GlassesStockItem glassesStockItem = GlassesStockItemEntity.toModel(entity, glassesOpt.get());
                glassesStockItemOpt = Optional.of(glassesStockItem);
            }
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
    public boolean removeGlassesStockItem(long id) {
        glassesStockCrudRepository.deleteById(id);
        return true;
    }
}
