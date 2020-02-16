package com.andybrook.service.order;

import com.andybrook.exception.*;
import com.andybrook.model.BarCode;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.orderitem.OrderItemInfo;

import java.util.List;

public interface IOrderItemService {

    List<OrderItem> createOrderItems(Order order, OrderItemInfo info, int quantityRequested);

    OrderItem createSingleOrderItemByBarCode(Order order, BarCode barCode);

    void delete(OrderItem orderItemId) throws OrderItemNotFound;

    boolean isExist(String id);
}
