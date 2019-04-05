package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.crudrepository.IOrderItemCrudRepository;
import com.andybrook.dao.jpa.entity.stock.OrderItemEntity;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
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
    public <T extends Product> Optional<OrderItem<T>> getOrderItem(long id) {
        Optional<OrderItem<T>> StockItemEntityOpt = Optional.empty();
        Optional<OrderItemEntity> entityOpt = findOne(id);
        if (entityOpt.isPresent()) {
            OrderItemEntity entity = entityOpt.get();
            OrderItem<T> orderItem = entityFactory.createOrderItem(entity);
            StockItemEntityOpt = Optional.of(orderItem);
        }
        return StockItemEntityOpt;
    }

    @Override
    public <T extends Product> OrderItem<T> updateStockItem(Order order, OrderItem<T> item) {
        OrderItemEntity entity = entityFactory.createOrderItemEntity(order, item);
        OrderItemEntity entitySaved = repository.save(entity);
        return entityFactory.createOrderItem(entitySaved);
    }

    @Override
    public <T extends Product> Map<Long, OrderItem<T>> getAllStockItems() {
        Map<Long, OrderItem<T>> itemsMapById = new HashMap<>();
        Iterable<OrderItemEntity> entities = repository.findAll();
        entities.forEach(e -> {
            OrderItem orderItem = entityFactory.createOrderItem(e);
            itemsMapById.put(orderItem.getId(), orderItem);
        });
        return itemsMapById;
    }

    @Override
    public boolean removeStockItem(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Optional<OrderItem<? extends Product>> findItemByBarCodeId(String barCodeId) {
        Optional<OrderItem<? extends Product>> resultOpt = Optional.empty();
        long stockItemId = barCodeDao.getStockItemIdByBarCodeId(barCodeId);
        Optional<OrderItemEntity> stockItemEntityOpt = findOne(stockItemId);
        if (stockItemEntityOpt.isPresent()) {
            OrderItem<Product> orderItem = entityFactory.createOrderItem(stockItemEntityOpt.get());
            resultOpt = Optional.of(orderItem);
        }
        return resultOpt;
    }

    private Optional<OrderItemEntity> findOne(long id) {
        return repository.findById(id);
    }
}
