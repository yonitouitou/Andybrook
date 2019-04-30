package com.andybrook.dao.order;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.order.OrderEntity;
import com.andybrook.dao.jpa.repository.IOrderCrudRepository;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.language.LanguageResolver;
import com.andybrook.language.Msg.Error;
import com.andybrook.model.order.Order;
import com.andybrook.model.request.order.UpdateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderDao implements IOrderDao {

    @Autowired
    private IOrderCrudRepository repository;
    @Autowired
    private EntityFactory entityFactory;
    @Autowired
    private LanguageResolver languageResolver;

    @Override
    public Order newOrder(Order order) {
        return updateOrder(order);
    }

    @Override
    public Order updateOrder(Order order) {
        OrderEntity entity = entityFactory.createOrderEntity(order);
        OrderEntity savedEntity = repository.save(entity);
        return entityFactory.createOrder(savedEntity);
    }

    @Override
    public void updateOrderAudit(Order order) {
        repository.updateOrderAuditing(order.getId(), LocalDateTime.now());
    }

    @Override
    public void updateOrder(UpdateOrderRequest request, boolean checkIfExist) throws OrderNotFound {
        if (checkIfExist) {
            boolean isExist = repository.existsById(request.getId());
            if (! isExist) {
                throw new OrderNotFound(languageResolver.get(Error.ORDER_NOT_FOUND + " : " + request.getId()));
            }
        }
        repository.updateExistingOrder(request.getId(), request.getName(), request.getComment());
    }

    @Override
    public Order get(long id) {
        OrderEntity entity = repository.getOne(id);
        return entityFactory.createOrder(entity);
    }

    @Override
    public Optional<Order> findOrder(long id) {
        Optional<OrderEntity> orderEntityOpt = repository.findById(id);
        Optional<Order> orderOpt = Optional.empty();
        if (orderEntityOpt.isPresent()) {
            Order order = entityFactory.createOrder(orderEntityOpt.get());
            orderOpt = Optional.of(order);
        }
        return orderOpt;
    }

    @Override
    public Set<Order> getAll(int limit) {
        Sort sortedByStatusAndCreationDatetime = new Sort(Direction.ASC, "status").and(new Sort(Direction.DESC, "LastModifiedDatetime"));
        Iterable<OrderEntity> allIterable = repository.findAll(PageRequest.of(0, limit, sortedByStatusAndCreationDatetime));
        Set<Order> all = new LinkedHashSet<>();
        allIterable.forEach(entity -> {
            Order order = entityFactory.createOrder(entity);
            all.add(order);
        });
        return all;
    }

    @Override
    public List<Order> getByName(String name) {
        List<OrderEntity> ordersEntity = repository.findByName(name);
        return ordersEntity.stream()
                .map(entityFactory::createOrder)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getByNameContaining(String name) {
        List<OrderEntity> ordersEntity = repository.findByNameContaining(name);
        return ordersEntity.stream()
                .map(entityFactory::createOrder)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrders(List<Long> ids) {
        List<OrderEntity> ordersEntity = repository.findByIdIn(ids);
        return ordersEntity.stream()
                .map(entityFactory::createOrder)
                .collect(Collectors.toList());
    }
}
