package com.andybrook.dao.order;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.order.Order;
import com.andybrook.model.request.order.UpdateOrderRequest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IOrderDao {

    Order save(Order order);

    void updateOrderAudit(Order order);

    void updateOrder(UpdateOrderRequest request, boolean checkIfExist) throws OrderNotFound;

    Optional<Order> get(long id);

    List<Order> getOrdersOfStore(long storeId);

    List<Order> getLastOrdersOfStore(long storeId, int lastOrderNb);

    Set<Order> getAll(int limit);

    List<Order> getByName(String name);

    List<Order> getByNameContaining(String name);

    List<Order> getOrders(List<Long> ids);
}
