package com.andybrook.service.stock;

import com.andybrook.dao.stock.IStockItemDao;
import com.andybrook.model.Product;
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

    @Override
    public StockItem<? extends Product> newStockItem(long stockReportId, StockItem<? extends Product> item) {
        //Glasses savedGlasses = glassesService.updateGlasses(item.getProduct());
        //item.getProduct().setId(savedGlasses.getId());
        return stockItemDao.updateStockItem(stockReportId, item);
    }

    @Override
    public StockItem<? extends Product> updateStockItem(long stockReportId, StockItem<? extends Product> item) {
        //glassesService.updateGlasses(item.getProduct());
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
