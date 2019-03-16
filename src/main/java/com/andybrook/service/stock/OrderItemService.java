package com.andybrook.service.stock;

import com.andybrook.dao.stock.IOrderItemDao;
import com.andybrook.exception.*;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.product.Product;
import com.andybrook.service.order.IOrderService;
import com.andybrook.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class OrderItemService implements IOrderItemService {

    @Autowired
    private IOrderItemDao stockItemDao;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IBarCodeService barCodeService;

    @Override
    @Transactional
    public StockItem<? extends Product> newOrderItem(long orderId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed {
        item.setId(IdGenerator.generateId());
        return orderService.addItemToOrder(orderId, item);
    }

    @Override
    @Transactional
    public StockItem<? extends Product> updateOrderItem(long orderId, StockItem<? extends Product> item)
            throws OrderNotFound, OrderClosed {
        StockItem<? extends Product> stockItem;
        StockReport order = orderService.getOrder(orderId);
        if (orderService.canModifyOrder(order)) {
            stockItem = update(order, item);
        } else {
            throw new OrderClosed(orderId);
        }
        return stockItem;
    }

    @Override
    public StockItem<? extends Product> getOrderItem(long id) throws OrderItemNotFound {
        StockItem<? extends Product> item;
        Optional<StockItem<Product>> stockItemOpt = stockItemDao.getStockItem(id);
        if (stockItemOpt.isPresent()) {
            item = stockItemOpt.get();
        } else {
            throw new OrderItemNotFound(id);
        }
        return item;
    }

    @Override
    public Map<Long, StockItem<? extends Product>> getOrderItems() {
        return null;//stockItemDao.getOrderItems();
    }

    @Override
    public boolean deleteOrderItem(long id) {
        stockItemDao.removeStockItem(id);
        return true;
    }

    @Override
    public StockItem<? extends Product> incrementQuantity(long orderId, long itemId) throws OrderItemNotFound, OrderNotFound {
        StockItem<? extends Product> stockItem;
        StockReport order = orderService.getOrder(orderId);
        if (orderService.canModifyOrder(order)) {
            Optional<StockItem<Product>> stockItemOpt = stockItemDao.getStockItem(itemId);
            if (stockItemOpt.isPresent()) {
                StockItem<Product> item = stockItemOpt.get();
                item.incrementQuantity();
                stockItem = update(order, item);
            } else {
                throw new OrderItemNotFound(itemId);
            }
        } else {
            throw new OrderNotFound(orderId);
        }
        return stockItem;
    }

    @Override
    public StockItem<? extends Product> incrementQuantityOrCreate(long orderId, StockItem<? extends Product> item) throws OrderNotFound, OrderClosed {
        StockItem<? extends Product> result;
        StockReport order = orderService.getOrder(orderId);
        if (orderService.canModifyOrder(order)) {
            if (item.exist()) {
                item.incrementQuantity();
            }
            result = stockItemDao.updateStockItem(order, item);
        } else {
            throw new OrderClosed(orderId);
        }
        return result;
    }

    @Override
    public StockItem<? extends Product> getOrderItemByBarCode(String barCodeId) throws BarCodeNotFound {
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

    private StockItem<? extends Product> update(StockReport order, StockItem<? extends Product> item) {
        return stockItemDao.updateStockItem(order, item);
    }
}
