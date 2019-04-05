package com.andybrook.manager.order;

import com.andybrook.exception.*;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemDeleteRequest;
import com.andybrook.model.request.orderitem.OrderItemUpdateRequest;

import java.util.List;
import java.util.Set;

public interface IOrderManager {

    Order newOrder(NewOrderRequest request) throws StoreNotFound;

    void updateOrder(UpdateOrderRequest updateRequest) throws OrderNotFound, OrderClosed;

    Order getOrder(long id) throws OrderNotFound;

    Set<Order> getAll();

    Order closeOrder(long id) throws OrderNotFound, OrderClosed;

    List<Order> getOrdersByName(String name);

    List<Order> getOrdersByNameContaining(String name);

    List<Order> getOrders(List<Long> ids);

    OrderItem<? extends Product> addOrderItem(OrderItemAddRequest request) throws OrderNotFound, OrderClosed, ProductNotFound, InsufficientQuantityException;

    OrderItem<? extends Product> updateOrderItem(OrderItemUpdateRequest request) throws OrderNotFound, OrderClosed, OrderItemNotFound, InsufficientQuantityException;

    Order deleteOrderItem(OrderItemDeleteRequest request) throws OrderNotFound, OrderClosed, OrderItemNotFound;
}
