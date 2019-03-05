package com.andybrook.manager.stock;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import com.andybrook.service.stock.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System.Logger;
import java.util.List;
import java.util.Set;

@Service
public class OrderManager implements IOrderManager {

    private static Logger LOGGER = System.getLogger(OrderManager.class.getSimpleName());

    @Autowired
    private IOrderService stockReportService;
    @Autowired
    private INotificationManager notificationManager;

    @Override
    public StockReport newStockReport(NewStockReportRequest request) throws StoreNotFound {
        return stockReportService.newStockReport(request);
    }

    @Override
    public void updateStockReport(UpdateStockReportRequest updateRequest) throws OrderNotFound, OrderClosed {
        stockReportService.updateStockReport(updateRequest);
    }

    @Override
    public StockReport getStockReport(long id) throws OrderNotFound {
        return stockReportService.getOrder(id);
    }

    @Override
    public List<StockReport> getOrdersByName(String name) {
        return stockReportService.getOrdersByName(name);
    }

    @Override
    public List<StockReport> getOrdersByNameContaining(String name) {
        return stockReportService.getOrderByNameContaining(name);
    }

    @Override
    public List<StockReport> getOrders(List<Long> ids) {
        return stockReportService.getOrders(ids);
    }

    @Override
    public Set<StockReport> getAll() {
        return stockReportService.getAll();
    }

    @Override
    public StockReport closeStockReport(long id) throws OrderNotFound, OrderClosed {
        StockReport stockReport = stockReportService.closeStockReport(id);
        notificationManager.notifyOrderClosed(stockReport);
        return stockReport;
    }


}
