package com.andybrook.service.order;

import com.andybrook.exception.*;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.model.request.orderitem.OrderItemRequest;

public interface IOrderItemService {

    OrderItem<? extends Product> createOrderItem(OrderItemInfo info) throws ProductNotFound, InsufficientQuantityException;

    OrderItem<? extends Product> updateOrderItem(OrderItem<? extends Product> orderItem, OrderItemInfo info) throws InsufficientQuantityException;

    void postDeletion(OrderItem<? extends Product> orderItemId) throws OrderItemNotFound;

    OrderItem<? extends Product> get(long id) throws OrderItemNotFound;

    boolean isExist(long id);
}
