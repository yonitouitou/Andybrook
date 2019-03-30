package com.andybrook.service.order;

import com.andybrook.dao.order.IOrderDao;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.language.LanguageResolver;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.model.request.UpdateOrderRequest;
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
    public Order addOrderItem(long orderId, OrderItem item) throws OrderNotFound, OrderClosed, ProductNotFound {
        Order order = getOrderById(orderId);
        item.setProduct(productService.get(item.getProduct().getId()));
        if (canModifyOrder(order)) {
            item.setIdIfNeeded();
            System.err.println("Added " + item.getId() + " | " + orderId);
            order.addItem(item);
            order = dao.updateOrder(order);
        } else {
            throw new OrderClosed(orderId);
        }
        return order;
    }

    @Override
    public Order updateOrderItem(long orderId, OrderItem item) throws OrderNotFound, OrderClosed {
        Order order = getOrderById(orderId);
        if (canModifyOrder(order)) {
            OrderItem<? extends Product> orderItem = order.getItem(item.getId());
            orderItem.update(item);
            dao.updateOrder(order);
        } else {
            throw new OrderClosed(orderId);
        }
        return order;
    }

    @Override
    public Order deleteOrderItem(long orderId, long orderItemId) throws OrderNotFound, OrderClosed {
        Order order = getOrderById(orderId);
        if (canModifyOrder(order)) {
            order.deleteItem(orderItemId);
            dao.updateOrder(order);
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
