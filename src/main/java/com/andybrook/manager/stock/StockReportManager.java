package com.andybrook.manager.stock;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import com.andybrook.model.StockReport;
import com.andybrook.service.stock.IStockReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StockReportManager implements IStockReportManager {

    @Autowired
    private IStockReportService stockReportService;

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
        stockReportService.closeStockReport(id);
    }
}
