package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.crudrepository.IOrderItemCrudRepository;
import com.andybrook.dao.jpa.entity.stock.OrderItemEntity;
import com.andybrook.model.StockReport;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderItemDao implements IOrderItemDao {

    @Autowired
    private IOrderItemCrudRepository repository;
    @Autowired
    private IBarCodeDao barCodeDao;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public <T extends Product> Optional<StockItem<T>> getStockItem(long id) {
        Optional<StockItem<T>> StockItemEntityOpt = Optional.empty();
        Optional<OrderItemEntity> entityOpt = findOne(id);
        if (entityOpt.isPresent()) {
            OrderItemEntity entity = entityOpt.get();
            StockItem<T> stockItem = entityFactory.createOrderItem(entity);
            StockItemEntityOpt = Optional.of(stockItem);
        }
        return StockItemEntityOpt;
    }

    @Override
    public <T extends Product> StockItem<T> updateStockItem(StockReport order, StockItem<T> item) {
        OrderItemEntity entity = entityFactory.createOrderItemEntity(order, item);
        OrderItemEntity entitySaved = repository.save(entity);
        return entityFactory.createOrderItem(entitySaved);
    }

    @Override
    public <T extends Product> Map<Long, StockItem<T>> getAllStockItems() {
        Map<Long, StockItem<T>> itemsMapById = new HashMap<>();
        Iterable<OrderItemEntity> entities = repository.findAll();
        entities.forEach(e -> {
            StockItem stockItem = entityFactory.createOrderItem(e);
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
        Optional<OrderItemEntity> stockItemEntityOpt = findOne(stockItemId);
        if (stockItemEntityOpt.isPresent()) {
            StockItem<Product> stockItem = entityFactory.createOrderItem(stockItemEntityOpt.get());
            resultOpt = Optional.of(stockItem);
        }
        return resultOpt;
    }

    private Optional<OrderItemEntity> findOne(long id) {
        return repository.findById(id);
    }
}
