package com.andybrook.manager.order;

import com.andybrook.exception.OrderItemNotFound;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.service.order.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderItemManager implements IOrderItemManager {

    @Autowired
    private IOrderItemService stockItemService;

    @Override
    public OrderItem<? extends Product> getOrderItem(long id) throws OrderItemNotFound {
        return stockItemService.get(id);
    }
}
