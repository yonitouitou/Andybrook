package com.andybrook.service.order;

import com.andybrook.exception.*;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;

import java.util.Map;

public interface IOrderItemService {

    OrderItem<? extends Product> get(long id) throws OrderItemNotFound;

    Map<Long, OrderItem<? extends Product>> getOrderItems();
}
