package com.andybrook.manager.order;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.model.StockReport;
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
    public StockReport newOrder(NewOrderRequest request) throws StoreNotFound {
        return orderService.newOrder(request);
    }

    @Override
    public void updateStockReport(UpdateOrderRequest updateRequest) throws OrderNotFound, OrderClosed {
        orderService.updateOrder(updateRequest);
    }

    @Override
    public StockReport getOrder(long id) throws OrderNotFound {
        return orderService.getOrder(id);
    }

    @Override
    public List<StockReport> getOrdersByName(String name) {
        return orderService.getOrdersByName(name);
    }

    @Override
    public List<StockReport> getOrdersByNameContaining(String name) {
        return orderService.getOrderByNameContaining(name);
    }

    @Override
    public List<StockReport> getOrders(List<Long> ids) {
        return orderService.getOrders(ids);
    }

    @Override
    public Set<StockReport> getAll() {
        return orderService.getAll();
    }

    @Override
    public StockReport closeOrder(long id) throws OrderNotFound, OrderClosed {
        StockReport stockReport = orderService.closeStockReport(id);
        notificationManager.notifyOrderClosed(stockReport);
        return stockReport;
    }


}
