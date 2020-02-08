package com.andybrook.manager.order;

import com.andybrook.exception.BarCodeNotFound;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderItemNotFound;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequestByBarCode;
import com.andybrook.model.request.orderitem.OrderItemDeleteRequest;

import java.util.List;
import java.util.Set;

public interface IOrderManager {

    Order newOrder(NewOrderRequest request) throws StoreNotFound;

    void updateOrder(UpdateOrderRequest updateRequest) throws OrderNotFound, OrderClosed;

    Order getOrder(long id) throws OrderNotFound;

    AggregatedOrder aggregate(Order order);

    AggregatedOrder aggregate(long orderId);

    Set<Order> getAll();

    Order closeOrder(long id) throws OrderNotFound, OrderClosed;

    List<Order> getOrdersByNameContaining(String name);

    List<Order> getOrders(List<Long> ids);

    List<Order> getOrdersOfStore(long storeId);

    List<OrderItem> addOrderItems(OrderItemAddRequest request) throws OrderNotFound, OrderClosed, ProductNotFound, InsufficientQuantityException, OrderItemNotFound, BarCodeNotFound;

    OrderItem addOrderItemByBarCode(OrderItemAddRequestByBarCode request);

    Order deleteOrderItem(OrderItemDeleteRequest request) throws OrderNotFound, OrderClosed, OrderItemNotFound;
}
