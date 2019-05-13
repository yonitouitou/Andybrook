package com.andybrook.manager.order;

import com.andybrook.enums.NotificationType;
import com.andybrook.exception.*;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequestByBarCode;
import com.andybrook.model.request.orderitem.OrderItemDeleteRequest;
import com.andybrook.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class OrderManager implements IOrderManager {

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
    public List<Order> getOrdersByNameContaining(String name) {
        return orderService.getOrderByNameContaining(name);
    }

    @Override
    public List<Order> getOrders(List<Long> ids) {
        return orderService.getOrders(ids);
    }

    @Override
    public List<Order> getOrdersOfCustomer(long customerId) {
        return orderService.getOrdersOfCustomer(customerId);
    }

    @Override
    public Set<Order> getAll() {
        return orderService.getAll();
    }

    @Override
    public Order closeOrder(long id) throws OrderNotFound, OrderClosed {
        Order order = orderService.closeOrder(id);
        notify(NotificationType.ORDER_CLOSED, order);
        return order;
    }

    @Override
    public List<OrderItem> addOrderItems(OrderItemAddRequest request)
            throws OrderNotFound, OrderClosed, ProductNotFound, InsufficientQuantityException, OrderItemNotFound, BarCodeNotFound {
        if (! OrderItemAddRequest.isValid(request)) {
            throw new IllegalArgumentException("Order item add request is not valid : " + request.toString());
        }
        return orderService.addOrderItems(request.getOrderId(), request.getProductItemInfo(), request.getQuantityRequested());
    }

    @Override
    public OrderItem addOrderItemByBarCode(OrderItemAddRequestByBarCode request) {
        if (! OrderItemAddRequestByBarCode.isValid(request)) {
            throw new IllegalArgumentException("Order item add request by barcode is not valid : " + request.toString());
        }
        return orderService.addSingleOrderItemByBarCode(request.getOrderId(), request.getBarCodeId());
    }

    @Override
    public Order deleteOrderItem(OrderItemDeleteRequest request) throws OrderNotFound, OrderClosed, OrderItemNotFound {
        if (! OrderItemDeleteRequest.isValid(request)) {
            throw new IllegalArgumentException("OrderItemDeleteRequest is not valid : " + request.toString());
        }
        return orderService.deleteOrderItem(request.getOrderId(), request.getOrderItemId());
    }

    private void notify(NotificationType type, Order order) {
        OrderDocumentCtx ctx = OrderDocumentCtx.builder(true, order).build();
        notificationManager.notify(new NotificationRequest(type, ctx));
    }
}
