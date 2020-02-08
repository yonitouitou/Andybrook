package com.andybrook.dao.order;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.order.Order;
import com.andybrook.model.request.order.UpdateOrderRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class OrderDao implements IOrderDao {

    @Autowired
    private IOrderRepository repository;

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public void updateOrderAudit(Order order) {
        repository.updateOrderAuditing(order.getId(), order.getLastModifiedDateTime());
    }

    @Override
    public void updateOrder(UpdateOrderRequest request, boolean checkIfExist) throws OrderNotFound {
        if (checkIfExist) {
            boolean isExist = repository.existsById(request.getId());
            if (! isExist) {
                throw new OrderNotFound(request.getId());
            }
        }
        repository.updateExistingOrder(request.getId(), request.getName(), request.getComment());
    }

    @Override
    public Optional<Order> get(long id) {
        return repository.findById(id);
    }

    @Override
    public Set<Order> getAll(int limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> getOrdersOfStore(long storeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> getLastOrdersOfStore(long storeId, int lastOrderNb) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> getByName(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> getByNameContaining(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> getOrders(List<Long> ids) {
        throw new UnsupportedOperationException();
    }
}
