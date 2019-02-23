package com.andybrook.manager.stock;

import com.andybrook.exception.StockReportClosed;
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
public class StockReportManager implements IStockReportManager {

    private static Logger LOGGER = System.getLogger(StockReportManager.class.getSimpleName());

    @Autowired
    private IOrderService stockReportService;
    @Autowired
    private INotificationManager notificationManager;

    @Override
    public StockReport newStockReport(NewStockReportRequest request) throws StoreNotFound {
        return stockReportService.newStockReport(request);
    }

    @Override
    public void updateStockReport(UpdateStockReportRequest updateRequest) throws OrderNotFound, StockReportClosed {
        stockReportService.updateStockReport(updateRequest);
    }

    @Override
    public StockReport getStockReport(long id) throws OrderNotFound {
        return stockReportService.getStockReport(id);
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
    public Set<StockReport> getAll() {
        return stockReportService.getAll();
    }

    @Override
    public StockReport closeStockReport(long id) throws OrderNotFound, StockReportClosed {
        StockReport stockReport = stockReportService.closeStockReport(id);
        notificationManager.notifyOrderClosed(stockReport);
        return stockReport;
    }
}
