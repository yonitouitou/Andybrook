package com.andybrook.manager.stock;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.StockReport;
import com.andybrook.model.notification.event.ctx.CloseReportEvent;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import com.andybrook.service.stock.IStockReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Set;

@Service
public class StockReportManager implements IStockReportManager {

    private static Logger LOGGER = System.getLogger(StockReportManager.class.getSimpleName());

    @Autowired
    private IStockReportService stockReportService;
    @Autowired
    private INotificationManager notificationManager;

    @Override
    public StockReport newStockReport(NewStockReportRequest request) {
        return stockReportService.newStockReport(request);
    }

    @Override
    public void updateStockReport(UpdateStockReportRequest updateRequest) throws StockReportNotFound, StockReportClosed {
        stockReportService.updateStockReport(updateRequest);
    }

    @Override
    public StockReport getStockReport(long id) throws StockReportNotFound {
        return stockReportService.getStockReport(id);
    }

    @Override
    public Set<StockReport> getAll() {
        return stockReportService.getAll();
    }

    @Override
    public StockReport closeStockReport(long id) throws StockReportNotFound, StockReportClosed {
        StockReport stockReport = stockReportService.closeStockReport(id);
        notificationManager.notifyReportClosed(stockReport);
        return stockReport;
    }
}
