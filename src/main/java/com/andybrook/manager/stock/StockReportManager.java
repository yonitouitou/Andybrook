package com.andybrook.manager.stock;

import com.andybrook.model.StockReport;
import com.andybrook.service.stock.IStockReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockReportManager implements IStockReportManager {

    @Autowired
    private IStockReportService stockReportService;

    @Override
    public StockReport newStockReport(String name) {
        return stockReportService.newStockReport(name);
    }
}
