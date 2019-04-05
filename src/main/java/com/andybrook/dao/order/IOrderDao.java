package com.andybrook.dao.order;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.Order;
import com.andybrook.model.request.order.UpdateOrderRequest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IOrderDao {

    Order newStockReport(Order order);

    Order updateOrder(Order order);

    void updateOrder(UpdateOrderRequest request, boolean checkIfExist) throws OrderNotFound;

    Order get(long id);

    Optional<Order> findStockReport(long id);

    Set<Order> getAll(int limit);

    List<Order> getByName(String name);

    List<Order> getByNameContaining(String name);

    List<Order> getOrders(List<Long> ids);
}
