package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.repository.IOrderItemCrudRepository;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemDao implements IOrderItemDao {

    @Autowired
    private IOrderItemCrudRepository repository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public OrderItem updateStockItem(Order order, OrderItem item) {
        /*OrderItemEntity entity = entityFactory.createOrderItemEntity(order, item);
        OrderItemEntity entitySaved = repository.save(entity);
        return entityFactory.createOrderItem(entitySaved);*/
        return null;
    }

    @Override
    public boolean isExist(long id) {
        return repository.existsById(id);
    }

    private Optional<OrderItemEntity> findOne(long id) {
        return repository.findById(id);
    }
}
