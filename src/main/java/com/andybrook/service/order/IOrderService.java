package com.andybrook.service.order;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.model.request.UpdateOrderRequest;

import java.util.List;
import java.util.Set;

public interface IOrderService {

    Order newOrder(NewOrderRequest request) throws StoreNotFound;

    void updateOrder(UpdateOrderRequest request) throws OrderNotFound, OrderClosed;

    Order getOrder(long id) throws OrderNotFound;

    Set<Order> getAll();

    Order closeStockReport(long id) throws OrderNotFound, OrderClosed;

    List<Order> getOrdersByName(String name);

    List<Order> getOrderByNameContaining(String name);

    List<Order> getOrders(List<Long> ids);

    boolean canModifyOrder(long id) throws OrderNotFound;

    boolean canModifyOrder(Order order);

    Order addOrderItem(long orderId, OrderItem item) throws OrderNotFound, OrderClosed;

    Order updateOrderItem(long orderId, OrderItem item) throws OrderNotFound, OrderClosed;

    Order deleteOrderItem(long orderId, long orderItemId) throws OrderNotFound, OrderClosed;
}
