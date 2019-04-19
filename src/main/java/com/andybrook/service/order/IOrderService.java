package com.andybrook.service.order;

import com.andybrook.exception.*;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;

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

    OrderItem addOrUpdateOrderItem(long orderId, OrderItemInfo info) throws OrderNotFound, OrderClosed, ProductNotFound, OrderItemNotFound, InsufficientQuantityException, BarCodeNotFound;

    Order deleteOrderItem(long orderId, long orderItemId) throws OrderNotFound, OrderClosed, OrderItemNotFound;
}
