package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.crudrepository.IStockItemCrudRepository;
import com.andybrook.dao.jpa.entity.stock.StockItemEntity;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StockItemDao implements IStockItemDao {

    @Autowired
    private IStockItemCrudRepository glassesStockCrudRepository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public <T extends Product> Optional<StockItem<T>> getStockItem(long id) {
        Optional<StockItem<T>> StockItemEntityOpt = Optional.empty();
        Optional<StockItemEntity> entityOpt = glassesStockCrudRepository.findById(id);
        if (entityOpt.isPresent()) {
            StockItemEntity entity = entityOpt.get();
            StockItem<T> stockItem = entityFactory.createStockItem(entity);
            StockItemEntityOpt = Optional.of(stockItem);
        }
        return StockItemEntityOpt;
    }

    @Override
    public <T extends Product> StockItem<T> updateStockItem(StockItem<T> item) {
        StockItemEntity entity = entityFactory.createStockItemEntity(item);
        StockItemEntity entitySaved = glassesStockCrudRepository.save(entity);
        item.setId(entitySaved.getId());
        return item;
    }

    @Override
    public <T extends Product> Map<Long, StockItem<T>> getAllStockItems() {
        Map<Long, StockItem<T>> itemsMapById = new HashMap<>();
        Iterable<StockItemEntity> entities = glassesStockCrudRepository.findAll();
        entities.forEach(e -> {
            StockItem stockItem = entityFactory.createStockItem(e);
            itemsMapById.put(stockItem.getId(), stockItem);
        });
        return itemsMapById;
    }

    @Override
    public boolean removeStockItem(long id) {
        glassesStockCrudRepository.deleteById(id);
        return true;
    }
}
