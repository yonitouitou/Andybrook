package com.andybrook.service.order;

import com.andybrook.dao.order.IOrderDao;
import com.andybrook.exception.*;
import com.andybrook.language.LanguageResolver;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.service.product.IProductService;
import com.andybrook.service.setting.IAdminSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.andybrook.language.Msg.Error.ORDER_NOT_FOUND;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao dao;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private LanguageResolver languageResolver;
    @Autowired
    private IAdminSettingService adminSettingService;

    @Override
    public Order newOrder(NewOrderRequest request) {
        Customer customer = customerService.getById(request.getCustomerId());
        Order order = new Order(null, request.getName(), customer);
        order.setComment(request.getComment());
        return dao.newStockReport(order);
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
        return dao.getAll(adminSettingService.getOrdersNbToShow());
    }

    @Override
    public Order closeStockReport(long id) throws OrderNotFound, OrderClosed {
        Order report = getOrder(id);
        report.close();
        return dao.updateOrder(report);
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
    public boolean canModifyOrder(long id) throws OrderNotFound {
        Order order = getOrder(id);
        return canModifyOrder(order);
    }

    @Override
    public boolean canModifyOrder(Order order) {
        return order.isOpen();
    }

    @Override
    public OrderItem<? extends Product> addOrderItem(long orderId, OrderItemInfo info) throws OrderNotFound, OrderClosed, ProductNotFound, InsufficientQuantityException {
        OrderItem<? extends Product> orderItemToUpdate;
        Order order = getOrderById(orderId);
        if (canModifyOrder(order)) {
            orderItemToUpdate = orderItemService.createOrderItem(info);
            order.addItem(orderItemToUpdate);
            dao.updateOrder(order);
        } else {
            throw new OrderClosed(orderId);
        }
        return orderItemToUpdate;
    }

    @Override
    public OrderItem<? extends Product> updateOrderItem(long orderId, OrderItemInfo info) throws OrderNotFound, OrderClosed, InsufficientQuantityException, OrderItemNotFound {
        OrderItem<? extends Product> orderItem;
        Order order = getOrderById(orderId);
        if (canModifyOrder(order)) {
            orderItem = order.getItem(info.getId());
            if (orderItem != null) {
                orderItemService.updateOrderItem(orderItem, info);
                dao.updateOrder(order);
            } else {
                throw new OrderItemNotFound(info.getId());
            }
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
                order.deleteItem(orderItemId);
                dao.updateOrder(order);
                orderItemService.postDeletion(orderItemId);
            } else {
                throw new OrderItemNotFound(orderItemId);
            }
        } else {
            throw new OrderClosed(orderId);
        }
        return order;
    }

    private Order getOrderById(long id) throws OrderNotFound {
        Optional<Order> reportOpt = dao.findStockReport(id);
        if (! reportOpt.isPresent()) {
            throw new OrderNotFound(languageResolver.get(ORDER_NOT_FOUND) + " : " + id);
        }
        return reportOpt.get();
    }
}
