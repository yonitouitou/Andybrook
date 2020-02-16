package com.andybrook.manager.order;

import com.andybrook.exception.BarCodeNotFound;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderItemNotFound;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.event.OrderClosedEvent;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequestByBarCode;
import com.andybrook.model.request.orderitem.OrderItemDeleteRequest;
import com.andybrook.service.order.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManager implements IOrderManager {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private ApplicationEventPublisher publisher;

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
    public AggregatedOrder aggregate(Order order) {
        return orderService.aggregate(order);
    }

    @Override
    public AggregatedOrder aggregate(long orderId) {
        return orderService.aggregate(orderId);
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
    public List<Order> getOrdersOfStore(long storeId) {
        return orderService.getOrdersOfStore(storeId);
    }

    @Override
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @Override
    public Order closeOrder(long id) throws OrderNotFound, OrderClosed {
        Order order = orderService.closeOrder(id);
        notifyCloseOrder(order);
        return order;
    }

    @Override
    public List<OrderItem> addOrderItems(OrderItemAddRequest request)
            throws OrderNotFound, OrderClosed, ProductNotFound, InsufficientQuantityException, OrderItemNotFound, BarCodeNotFound {
        if (! OrderItemAddRequest.isValid(request)) {
            throw new IllegalArgumentException("Order item add request is not valid : " + request.toString());
        }
        return orderService.addOrderItems(request.getOrderId(), request.getOrderItemInfo(), request.getQuantityRequested());
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

    private void notifyCloseOrder(Order order) {
        publisher.publishEvent(new OrderClosedEvent(order));
    }
}
