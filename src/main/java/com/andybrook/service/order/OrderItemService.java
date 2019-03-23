package com.andybrook.service.order;

import com.andybrook.dao.stock.IOrderItemDao;
import com.andybrook.exception.*;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.service.product.IBarCodeService;
import com.andybrook.service.product.IProductService;
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
    @Autowired
    private IProductService productService;

    @Override
    public OrderItem<? extends Product> get(long id) throws OrderItemNotFound {
        OrderItem<? extends Product> item;
        Optional<OrderItem<Product>> stockItemOpt = stockItemDao.getStockItem(id);
        if (stockItemOpt.isPresent()) {
            item = stockItemOpt.get();
        } else {
            throw new OrderItemNotFound(id);
        }
        return item;
    }

    @Override
    public Map<Long, OrderItem<? extends Product>> getOrderItems() {
        return null;//stockItemDao.getOrderItems();
    }

    /*@Override
    public OrderItem<? extends Product> incrementQuantity(long orderId, long itemId) throws OrderItemNotFound, OrderNotFound {
        OrderItem<? extends Product> orderItem;
        Order order = orderService.getOrder(orderId);
        if (orderService.canModifyOrder(order)) {
            Optional<OrderItem<Product>> stockItemOpt = stockItemDao.getStockItem(itemId);
            if (stockItemOpt.isPresent()) {
                OrderItem<Product> item = stockItemOpt.get();
                item.incrementQuantity();
                orderItem = update(order, item);
            } else {
                throw new OrderItemNotFound(itemId);
            }
        } else {
            throw new OrderNotFound(orderId);
        }
        return orderItem;
    }*/
}
