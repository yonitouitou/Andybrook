package com.andybrook.manager.order;

import com.andybrook.exception.*;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;

import java.util.Map;

public interface IOrderItemManager {

    OrderItem<? extends Product> getOrderItem(long id) throws OrderItemNotFound;
}
