package com.andybrook.service.order;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderItemNotFound;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;

import java.util.List;

public interface IOrderService {

    Order newOrder(NewOrderRequest request) throws StoreNotFound;

    void updateOrder(UpdateOrderRequest request) throws OrderNotFound, OrderClosed;

    Order getOrder(long id) throws OrderNotFound;

    List<Order> getAll();

    AggregatedOrder aggregate(Order order);

    AggregatedOrder aggregate(long orderId);

    Order closeOrder(long id) throws OrderNotFound, OrderClosed;

    List<Order> getOrdersByName(String name);

    List<Order> getOrderByNameContaining(String name);

    List<Order> getOrders(List<Long> ids);

    List<Order> getOrdersOfStore(long storeId);

    List<Order> getLastOrdersOfStore(long storeId, int lastOrderNb);

    boolean canModifyOrder(long id) throws OrderNotFound;

    boolean canModifyOrder(Order order);

    List<OrderItem> addOrderItems(long orderId, OrderItemInfo info, int quantity);

    OrderItem addSingleOrderItemByBarCode(long orderId, String barCodeId);

    Order deleteOrderItem(long orderId, String orderItemId) throws OrderNotFound, OrderClosed, OrderItemNotFound;

    double getAmount(Order order);
}
