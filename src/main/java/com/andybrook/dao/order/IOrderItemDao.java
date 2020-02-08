package com.andybrook.dao.order;

import com.andybrook.model.order.OrderItem;

import java.util.Optional;

public interface IOrderItemDao {

    void save(OrderItem item);

    Optional<OrderItem> get(long orderItemId);

    void delete(long orderItemId);

    boolean isExist(long id);
}
