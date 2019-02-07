package com.andybrook.manager.stock;

import com.andybrook.api.rest.StockItemController;
import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.manager.notification.INotificationManager;
import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import com.andybrook.model.StockReport;
import com.andybrook.service.stock.IStockReportService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IAdminSettingManager adminSettingManager;

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
    public void closeStockReport(long id) throws StockReportNotFound, StockReportClosed {
        StockReport stockReport = stockReportService.closeStockReport(id);
        if (adminSettingManager.shouldNotifyOnCloseReport()) {
            notify(stockReport);
        }
    }

    private void notify(StockReport report) {
        try {
            notificationManager.notifyReportClosed(report);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Mail not sent for report " + report.getName(), e);
        }
    }
}
