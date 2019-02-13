package com.andybrook.service.stock;

import com.andybrook.dao.stock.IStockItemDao;
import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class StockItemService implements IStockItemService {

    @Autowired
    private IStockItemDao stockItemDao;
    @Autowired
    private IStockReportService stockReportService;

    @Override
    @Transactional
    public StockItem<? extends Product> newStockItem(long stockReportId, StockItem<? extends Product> item)
            throws StockReportNotFound, StockReportClosed {
        StockReport stockReport = stockReportService.getStockReport(stockReportId);
        if (! stockReport.isClosed()) {
            stockReportService.addItemToReport(stockReportId, item);
        } else {
            throw new StockReportClosed(stockReportId);
        }
        return item;
    }

    @Override
    @Transactional
    public StockItem<? extends Product> updateStockItem(long stockReportId, StockItem<? extends Product> item)
            throws StockReportNotFound, StockReportClosed {

        StockItem<? extends Product> stockItem;
        StockReport stockReport = stockReportService.getStockReport(stockReportId);
        if (! stockReport.isClosed()) {
            stockItem = stockItemDao.updateStockItem(stockReportId, item);
        } else {
            throw new StockReportClosed(stockReportId);
        }
        return stockItem;
    }

    @Override
    public Optional<StockItem<? extends Product>> getStockItem(long id) {
        return null;//stockItemDao.getStockItem(id);
    }

    @Override
    public Map<Long, StockItem<? extends Product>> getAllStockItems() {
        return null;//stockItemDao.getAllStockItems();
    }

    @Override
    @Transactional
    public boolean removeStockItem(long id) {
        stockItemDao.removeStockItem(id);
        return true;
    }
}
