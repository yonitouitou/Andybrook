package com.andybrook.service.order;

import com.andybrook.exception.*;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.OrderItemInfo;

public interface IOrderItemService {

    OrderItem createOrderItem(OrderItemInfo info) throws ProductNotFound, InsufficientQuantityException, BarCodeNotFound;

    OrderItem updateOrderItem(OrderItem orderItem, OrderItemInfo info) throws InsufficientQuantityException;

    void postDeletion(OrderItem orderItemId) throws OrderItemNotFound;

    boolean isExist(long id);
}
