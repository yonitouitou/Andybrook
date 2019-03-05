package com.andybrook.service.stock;

import com.andybrook.dao.stock.IStockItemDao;
import com.andybrook.exception.StockItemNotFound;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
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
    private IOrderService orderService;

    @Override
    @Transactional
    public StockItem<? extends Product> newStockItem(long stockReportId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed {
        StockReport stockReport = orderService.getOrder(stockReportId);
        if (! stockReport.isClosed()) {
            orderService.addItemToReport(stockReportId, item);
        } else {
            throw new OrderClosed(stockReportId);
        }
        return item;
    }

    @Override
    @Transactional
    public StockItem<? extends Product> updateStockItem(long orderId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed {

        StockItem<? extends Product> stockItem;
        if (orderService.canModifyOrder(orderId)) {
            stockItem = update(item);
        } else {
            throw new OrderClosed(orderId);
        }
        return stockItem;
    }

    @Override
    public StockItem<? extends Product> getStockItem(long id) throws StockItemNotFound {
        StockItem<? extends Product> item;
        Optional<StockItem<Product>> stockItemOpt = stockItemDao.getStockItem(id);
        if (stockItemOpt.isPresent()) {
            item = stockItemOpt.get();
        } else {
            throw new StockItemNotFound(id);
        }
        return item;
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

    @Override
    public StockItem<? extends Product> incrementQuantity(long orderId, long itemId) throws StockItemNotFound, OrderNotFound {
        StockItem<? extends Product> stockItem;
        if (orderService.canModifyOrder(orderId)) {
            Optional<StockItem<Product>> stockItemOpt = stockItemDao.getStockItem(itemId);
            if (stockItemOpt.isPresent()) {
                StockItem<Product> item = stockItemOpt.get();
                item.incrementQuantity();
                stockItem = update(item);
            } else {
                throw new StockItemNotFound(itemId);
            }
        } else {
            throw new OrderNotFound(orderId);
        }
        return stockItem;
    }

    private StockItem<? extends Product> update(StockItem<? extends Product> item) {
        return stockItemDao.updateStockItem(item);
    }
}
