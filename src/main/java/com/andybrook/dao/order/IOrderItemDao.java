package com.andybrook.dao.order;

import com.andybrook.model.order.OrderItem;

import java.util.Optional;

public interface IOrderItemDao {

    void save(OrderItem item);

    Optional<OrderItem> get(String orderItemId);

    void delete(String orderItemId);

    boolean isExist(String id);
}
