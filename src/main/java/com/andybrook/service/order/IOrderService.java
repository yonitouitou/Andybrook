package com.andybrook.service.order;

import com.andybrook.exception.*;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.ProductItemInfo;

import java.util.List;
import java.util.Set;

public interface IOrderService {

    Order newOrder(NewOrderRequest request) throws StoreNotFound;

    void updateOrder(UpdateOrderRequest request) throws OrderNotFound, OrderClosed;

    Order getOrder(long id) throws OrderNotFound;

    Set<Order> getAll();

    Order closeOrder(long id) throws OrderNotFound, OrderClosed;

    List<Order> getOrdersByName(String name);

    List<Order> getOrderByNameContaining(String name);

    List<Order> getOrders(List<Long> ids);

    List<Order> getOrdersOfStore(long storeId);

    List<Order> getLastOrdersOfStore(long storeId, int lastOrderNb);

    boolean canModifyOrder(long id) throws OrderNotFound;

    boolean canModifyOrder(Order order);

    List<OrderItem> addOrderItems(long orderId, ProductItemInfo info, int quantity);

    OrderItem addSingleOrderItemByBarCode(long orderId, String barCodeId);

    Order deleteOrderItem(long orderId, long orderItemId) throws OrderNotFound, OrderClosed, OrderItemNotFound;
}
