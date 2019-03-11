package com.andybrook.service.stock;

import com.andybrook.dao.stock.IStockDao;
import com.andybrook.exception.*;
import com.andybrook.model.BarCode;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;
import com.andybrook.service.order.IOrderService;
import com.andybrook.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class StockItemService implements IStockItemService {

    @Autowired
    private IStockDao stockItemDao;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IBarCodeService barCodeService;

    @Override
    @Transactional
    public StockItem<? extends Product> newStockItem(long orderId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed {
        item.setId(IdGenerator.generateId());
        return orderService.addItemToOrder(orderId, item);
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

    @Override
    public StockItem<? extends Product> incrementQuantityOrCreate(long orderId, StockItem<? extends Product> item) throws OrderNotFound, OrderClosed {
        StockItem<? extends Product> result;
        if (orderService.canModifyOrder(orderId)) {
            if (item.exist()) {
                item.incrementQuantity();
            }
            result = stockItemDao.updateStockItem(item);
        } else {
            throw new OrderClosed(orderId);
        }
        return result;
    }

    @Override
    public StockItem<? extends Product> getStockItemByBarCode(String barCodeId) throws BarCodeNotFound {
        StockItem<? extends Product> stockItem;
        long stockItemId = barCodeService.getStockItemIdByBarCodeId(barCodeId);
        Optional<StockItem<Product>> stockItemOpt = stockItemDao.getStockItem(stockItemId);
        if (stockItemOpt.isPresent()) {
            stockItem = stockItemOpt.get();
        } else {
            throw new BarCodeNotFound(barCodeId);
        }
        return stockItem;
    }

    private StockItem<? extends Product> update(StockItem<? extends Product> item) {
        return stockItemDao.updateStockItem(item);
    }
}
