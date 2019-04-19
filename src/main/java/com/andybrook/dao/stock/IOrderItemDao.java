package com.andybrook.dao.stock;

import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;

import java.util.Map;
import java.util.Optional;

public interface IOrderItemDao {

    OrderItem updateStockItem(Order order, OrderItem item);

    boolean isExist(long id);
}
