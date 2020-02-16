package com.andybrook.service.order;

import com.andybrook.dao.order.IOrderDao;
import com.andybrook.exception.BarCodeNotFound;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderItemNotFound;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.order.IOrderAggregator;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderAggregator;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.service.product.IProductService;
import com.andybrook.service.setting.IAdminSettingService;
import com.andybrook.service.stock.IStockService;
import com.andybrook.util.clock.Clock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private IOrderDao dao;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private IStockService stockService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IAdminSettingService adminSettingService;

    @Override
    public Order newOrder(NewOrderRequest request) {
        Order order = new Order(request.getName(), request.getStoreId());
        order.setComment(request.getComment());
        dao.save(order);
        return order;
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
    public List<Order> getAll() {
        return dao.getAll(adminSettingService.getLoadItemsLimit());
    }

    @Override
    public AggregatedOrder aggregate(Order order) {
        IOrderAggregator aggregator = applicationContext.getBean(OrderAggregator.class);
        return aggregator.aggregate(order);
    }

    @Override
    public AggregatedOrder aggregate(long orderId) {
        Order order = getOrder(orderId);
        return aggregate(order);
    }

    @Override
    public Order closeOrder(long id) throws OrderNotFound, OrderClosed {
        Order order = getOrder(id);
        order.close();
        dao.save(order);
        return order;
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
    public List<OrderItem> addOrderItems(long orderId, OrderItemInfo info, int quantity)
            throws OrderNotFound, OrderClosed, ProductNotFound, OrderItemNotFound, InsufficientQuantityException, BarCodeNotFound {
        List<OrderItem> orderItems;
        Order order = getOrderById(orderId);
        if (canModifyOrder(order)) {
            orderItems = orderItemService.createOrderItems(order, info, quantity);
            order.addOrderItems(orderItems);
            dao.save(order);
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
            orderItem = orderItemService.createSingleOrderItemByBarCode(order, new BarCode(barCodeId));
            order.addOrderItem(orderItem);
            dao.save(order);
        } else {
            throw new OrderClosed(orderId);
        }
        return orderItem;
    }

    @Override
    public Order deleteOrderItem(long orderId, String orderItemId) throws OrderNotFound, OrderClosed, OrderItemNotFound {
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

    @Override
    public double getAmount(Order order) {
        return order.getOrderItems()
                .stream()
                .map(orderItem -> stockService.getProductItem(orderItem.getProductItemId()))
                .map(productItem -> productService.get(productItem.getProductId()))
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private Order getOrderById(long id) throws OrderNotFound {
        Optional<Order> orderOpt = dao.get(id);
        if (! orderOpt.isPresent()) {
            throw new OrderNotFound(id);
        }
        return orderOpt.get();
    }

    private void updateAudit(Order order) {
        order.setLastModifiedDateTime(Clock.millis());
        dao.save(order);
    }
}
