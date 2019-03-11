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
public class StockDao implements IStockDao {

    @Autowired
    private IStockItemCrudRepository repository;
    @Autowired
    private IBarCodeDao barCodeDao;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public <T extends Product> Optional<StockItem<T>> getStockItem(long id) {
        Optional<StockItem<T>> StockItemEntityOpt = Optional.empty();
        Optional<StockItemEntity> entityOpt = findOne(id);
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
        StockItemEntity entitySaved = repository.save(entity);
        return entityFactory.createStockItem(entitySaved);
    }

    @Override
    public <T extends Product> Map<Long, StockItem<T>> getAllStockItems() {
        Map<Long, StockItem<T>> itemsMapById = new HashMap<>();
        Iterable<StockItemEntity> entities = repository.findAll();
        entities.forEach(e -> {
            StockItem stockItem = entityFactory.createStockItem(e);
            itemsMapById.put(stockItem.getId(), stockItem);
        });
        return itemsMapById;
    }

    @Override
    public boolean removeStockItem(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Optional<StockItem<? extends Product>> findItemByBarCodeId(String barCodeId) {
        Optional<StockItem<? extends Product>> resultOpt = Optional.empty();
        long stockItemId = barCodeDao.getStockItemIdByBarCodeId(barCodeId);
        Optional<StockItemEntity> stockItemEntityOpt = findOne(stockItemId);
        if (stockItemEntityOpt.isPresent()) {
            StockItem<Product> stockItem = entityFactory.createStockItem(stockItemEntityOpt.get());
            resultOpt = Optional.of(stockItem);
        }
        return resultOpt;
    }

    private Optional<StockItemEntity> findOne(long id) {
        return repository.findById(id);
    }
}
