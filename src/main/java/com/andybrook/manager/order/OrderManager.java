package com.andybrook.manager.order;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.model.request.UpdateOrderRequest;
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
    public Order addOrderItem(long orderId, OrderItem<? extends Product> item) throws OrderNotFound, OrderClosed, ProductNotFound {
        return orderService.addOrderItem(orderId, item);
    }

    @Override
    public Order updateOrderItem(long orderId, OrderItem<? extends Product> item) throws OrderNotFound, OrderClosed {
        return orderService.updateOrderItem(orderId, item);
    }

    @Override
    public Order deleteOrderItem(long orderId, long orderItemId) throws OrderNotFound, OrderClosed {
        return orderService.deleteOrderItem(orderId, orderItemId);
    }
}
