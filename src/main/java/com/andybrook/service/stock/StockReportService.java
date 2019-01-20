package com.andybrook.service.stock;

import com.andybrook.dao.stock.IStockItemDao;
import com.andybrook.dao.stock.IStockReportDao;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.Product;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class StockReportService implements IStockReportService {

    @Autowired
    private IStockReportDao stockReportDao;
    @Autowired
    private IStockItemDao stockItemDao;

    @Override
    public StockReport newStockReport(String name) {
        StockReport report = new StockReport(null, name, new HashMap<>());
        return stockReportDao.newStockReport(report);
    }

    @Override
    public void addItemToReport(long stockRepordId, StockItem<? extends Product> item) throws StockReportNotFound {
        Optional<StockReport> stockReportOpt = stockReportDao.getStockReport(stockRepordId);
        if (stockReportOpt.isPresent()) {
            StockReport stockReport = stockReportOpt.get();
            stockReport.addItem(item);
            stockReport = stockReportDao.updateStockReport(stockReport);
        } else {
            throw new StockReportNotFound(stockRepordId);
        }
    }
}
