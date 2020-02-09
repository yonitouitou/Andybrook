package com.andybrook.dao.order;

import com.andybrook.model.order.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemDao implements IOrderItemDao {

    @Autowired
    private IOrderItemRepository repository;

    @Override
    public void save(OrderItem item) {
        repository.save(item);
    }

    @Override
    public boolean isExist(long id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<OrderItem> get(long orderItemId) {
        return repository.findById(orderItemId);
    }

    @Override
    public void delete(long orderItemId) {
        repository.deleteById(orderItemId);
    }
}
