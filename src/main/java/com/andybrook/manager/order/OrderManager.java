package com.andybrook.manager.order;

import com.andybrook.exception.*;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemDeleteRequest;
import com.andybrook.model.request.orderitem.OrderItemUpdateRequest;
import com.andybrook.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System.Logger;
import java.util.List;
import java.util.Set;

@Service
public class OrderManager implements IOrderManager {

    private static Logger LOGGER = System.getLogger(OrderManager.class.getSimpleName());

    @Autowired
    private IOrderService orderService;
    @Autowired
    private INotificationManager notificationManager;

    @Override
    public Order newOrder(NewOrderRequest request) throws StoreNotFound {
        return orderService.newOrder(request);
    }

    @Override
    public void updateOrder(UpdateOrderRequest updateRequest) throws OrderNotFound, OrderClosed {
        orderService.updateOrder(updateRequest);
    }

    @Override
    public Order getOrder(long id) throws OrderNotFound {
        return orderService.getOrder(id);
    }

    @Override
    public List<Order> getOrdersByName(String name) {
        return orderService.getOrdersByName(name);
    }

    @Override
    public List<Order> getOrdersByNameContaining(String name) {
        return orderService.getOrderByNameContaining(name);
    }

    @Override
    public List<Order> getOrders(List<Long> ids) {
        return orderService.getOrders(ids);
    }

    @Override
    public Set<Order> getAll() {
        return orderService.getAll();
    }

    @Override
    public Order closeOrder(long id) throws OrderNotFound, OrderClosed {
        Order order = orderService.closeStockReport(id);
        notificationManager.notifyOrderClosed(order);
        return order;
    }

    @Override
    public OrderItem addOrderItem(OrderItemAddRequest request)
            throws OrderNotFound, OrderClosed, ProductNotFound, InsufficientQuantityException, OrderItemNotFound, BarCodeNotFound {
        if (! OrderItemAddRequest.isValid(request)) {
            throw new IllegalArgumentException("Order item add request is not valid : " + request.toString());
        }
        return orderService.addOrUpdateOrderItem(request.getOrderId(), request.getOrderItemInfo());
    }

    @Override
    public OrderItem updateOrderItem(OrderItemUpdateRequest request)
            throws OrderNotFound, OrderClosed, OrderItemNotFound, InsufficientQuantityException, ProductNotFound, BarCodeNotFound {
        if (! OrderItemUpdateRequest.isValid(request)) {
            throw new IllegalArgumentException("OrderItemUpdateRequest is not valid : " + request.toString());
        }
        return orderService.addOrUpdateOrderItem(request.getOrderId(), request.getOrderItemInfo());
    }

    @Override
    public Order deleteOrderItem(OrderItemDeleteRequest request) throws OrderNotFound, OrderClosed, OrderItemNotFound {
        if (! OrderItemDeleteRequest.isValid(request)) {
            throw new IllegalArgumentException("OrderItemDeleteRequest is not valid : " + request.toString());
        }
        return orderService.deleteOrderItem(request.getOrderId(), request.getOrderItemId());
    }
}
