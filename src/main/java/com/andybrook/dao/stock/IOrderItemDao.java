package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;

import java.util.Map;
import java.util.Optional;

public interface IOrderItemDao {

    void update(Order order, OrderItem item);

    OrderItem get(long orderItemId);

    void delete(long orderItemId);

    OrderItemEntity getEntity(long orderItemId);

    boolean isExist(long id);
}
