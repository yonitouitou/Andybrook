package com.andybrook.service.order;

import com.andybrook.dao.order.IOrderDao;
import com.andybrook.exception.*;
import com.andybrook.model.BarCode;
import com.andybrook.model.customer.Store;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.service.setting.IAdminSettingService;
import com.andybrook.service.store.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao dao;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private IStoreService storeService;
    @Autowired
    private IAdminSettingService adminSettingService;

    @Override
    public Order newOrder(NewOrderRequest request) {
        Store store = storeService.getById(request.getStoreId());
        Order order = new Order(null, request.getName(), store);
        order.setComment(request.getComment());
        return dao.newOrder(order);
    }

    @Override
    public void updateOrder(UpdateOrderRequest request) throws OrderNotFound, OrderClosed {
        if (canModifyOrder(request.getId())) {
            dao.updateOrder(request, false);
        } else {
            throw new OrderClosed(request.getId());
        }
    }

    @Override
    public Order getOrder(long id) throws OrderNotFound {
        return getOrderById(id);
    }

    @Override
    public Set<Order> getAll() {
        return dao.getAll(adminSettingService.getLoadItemsLimit());
    }

    @Override
    public Order closeOrder(long id) throws OrderNotFound, OrderClosed {
        Order order = getOrder(id);
        order.close();
        return dao.updateOrder(order);
    }

    @Override
    public List<Order> getOrdersByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public List<Order> getOrderByNameContaining(String name) {
        return dao.getByNameContaining(name);
    }

    @Override
    public List<Order> getOrders(List<Long> ids) {
        return dao.getOrders(ids);
    }

    @Override
    public List<Order> getOrdersOfStore(long storeId) {
        return dao.getOrdersOfStore(storeId);
    }

    @Override
    public List<Order> getLastOrdersOfStore(long storeId, int lastOrderNb) {
        return dao.getLastOrdersOfStore(storeId, lastOrderNb);
    }

    @Override
    public boolean canModifyOrder(long id) throws OrderNotFound {
        Order order = getOrder(id);
        return canModifyOrder(order);
    }

    @Override
    public boolean canModifyOrder(Order order) {
        return order.isOpen();
    }

    @Override
    public List<OrderItem> addOrderItems(long orderId, ProductItemInfo info, int quantity)
            throws OrderNotFound, OrderClosed, ProductNotFound, OrderItemNotFound, InsufficientQuantityException, BarCodeNotFound {
        List<OrderItem> orderItems;
        Order order = getOrderById(orderId);
        if (canModifyOrder(order)) {
            orderItems = orderItemService.createOrderItems(order, info, quantity);
            order.addOrderItems(orderItems);
            dao.updateOrder(order);
        } else {
            throw new OrderClosed(orderId);
        }
        return orderItems;
    }

    @Override
    public OrderItem addSingleOrderItemByBarCode(long orderId, String barCodeId) {
        OrderItem orderItem;
        Order order = getOrderById(orderId);
        if (canModifyOrder(order)) {
            orderItem = orderItemService.createSingleItemByBarCode(new BarCode(barCodeId));
            order.addOrderItem(orderItem);
            dao.updateOrder(order);
        } else {
            throw new OrderClosed(orderId);
        }
        return orderItem;
    }

    @Override
    public Order deleteOrderItem(long orderId, long orderItemId) throws OrderNotFound, OrderClosed, OrderItemNotFound {
        Order order = getOrderById(orderId);
        if (canModifyOrder(order)) {
            if (order.getItem(orderItemId) != null) {
                OrderItem deletedOrderItem = order.deleteItem(orderItemId);
                orderItemService.delete(deletedOrderItem);
                updateAudit(order);
            } else {
                throw new OrderItemNotFound(orderItemId);
            }
        } else {
            throw new OrderClosed(orderId);
        }
        return order;
    }

    private Order getOrderById(long id) throws OrderNotFound {
        Optional<Order> orderOpt = dao.findOrder(id);
        if (! orderOpt.isPresent()) {
            throw new OrderNotFound(id);
        }
        return orderOpt.get();
    }

    private void updateAudit(Order order) {
        order.setLastModifiedDateTime(LocalDateTime.now());
        dao.updateOrderAudit(order);
    }
}
