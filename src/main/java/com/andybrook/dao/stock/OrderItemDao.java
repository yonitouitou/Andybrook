package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.order.OrderEntity;
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
    public void update(Order order, OrderItem item) {
        OrderEntity orderEntity = entityFactory.createOrderEntity(order);
        OrderItemEntity entity = entityFactory.createOrderItemEntityByProductType(orderEntity, item);
        OrderItemEntity entitySaved = repository.save(entity);
        item.setId(entitySaved.getId());
    }

    @Override
    public boolean isExist(long id) {
        return repository.existsById(id);
    }

    @Override
    public OrderItem get(long orderItemId) {
        OrderItemEntity entity = repository.getOne(orderItemId);
        return entityFactory.createOrderItem(entity);
    }

    @Override
    public void delete(long orderItemId) {
        repository.deleteById(orderItemId);
    }

    @Override
    public OrderItemEntity getEntity(long orderItemId) {
        return repository.getOne(orderItemId);
    }

    private Optional<OrderItemEntity> findOne(long id) {
        return repository.findById(id);
    }
}
