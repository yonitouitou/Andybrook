package com.andybrook.manager.order;

import com.andybrook.exception.*;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequestByBarCode;
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

    List<Order> getOrdersByNameContaining(String name);

    List<Order> getOrders(List<Long> ids);

    List<Order> getOrdersOfStore(long storeId);

    List<OrderItem> addOrderItems(OrderItemAddRequest request) throws OrderNotFound, OrderClosed, ProductNotFound, InsufficientQuantityException, OrderItemNotFound, BarCodeNotFound;

    OrderItem addOrderItemByBarCode(OrderItemAddRequestByBarCode request);

    Order deleteOrderItem(OrderItemDeleteRequest request) throws OrderNotFound, OrderClosed, OrderItemNotFound;
}
