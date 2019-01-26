package com.andybrook.service.stock;

import com.andybrook.dao.stock.IStockItemDao;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
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
    public StockItem<? extends Product> newStockItem(long stockReportId, StockItem<? extends Product> item) throws StockReportNotFound {
        stockReportService.addItemToReport(stockReportId, item);
        return item;
    }

    @Override
    public StockItem<? extends Product> updateStockItem(long stockReportId, StockItem<? extends Product> item) throws StockReportNotFound {
        return stockItemDao.updateStockItem(stockReportId, item);
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
