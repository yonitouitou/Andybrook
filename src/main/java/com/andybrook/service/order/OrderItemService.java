package com.andybrook.service.order;

import com.andybrook.dao.stock.IOrderItemDao;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.ProductItemNotFree;
import com.andybrook.model.BarCode;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.stock.IStockService;
import com.andybrook.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderItemService implements IOrderItemService {

    @Autowired
    private IOrderItemDao dao;
    @Autowired
    private IStockService stockService;

    @Override
    public List<OrderItem> createOrderItems(ProductItemInfo info, int quantityRequested) {
        List<OrderItem> orderItems = new LinkedList<>();
        int freeQuantity = stockService.getFreeQuantity(info.getProductId());
        if (freeQuantity >= quantityRequested) {
            ProductItem productItem = stockService.getProductItem(info.getProductId());
            orderItems.add(buildOrderItem(productItem));
        } else {
            throw new InsufficientQuantityException(freeQuantity);
        }
        return orderItems;
    }

    @Override
    public OrderItem createSingleItemByBarCode(BarCode barCode) {
        ProductItem productItem = stockService.getProductItemByBarCode(barCode);
        if (productItem.isInOrder()) {
            throw new ProductItemNotFree(productItem.getId());
        }
        return buildOrderItem(productItem);
    }

    @Override
    public void postDeletion(OrderItem deletedOrderItem) {

    }

    @Override
    public boolean isExist(long id) {
        return dao.isExist(id);
    }

    private OrderItem buildOrderItem(ProductItem productItem) {
        return new OrderItem(IdGenerator.generateId(), productItem);
    }
}
