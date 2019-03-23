package com.andybrook.dao.stock;

import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;

import java.util.Map;
import java.util.Optional;

public interface IOrderItemDao {

    <T extends Product> Optional<OrderItem<T>> getStockItem(long id);

    <T extends Product> OrderItem<T> updateStockItem(Order order, OrderItem<T> item);

    <T extends Product> Map<Long, OrderItem<T>> getAllStockItems();

    boolean removeStockItem(long id);

    Optional<OrderItem<? extends Product>> findItemByBarCodeId(String barCodeId);
}
