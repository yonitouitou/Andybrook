package com.andybrook.service.order;

import com.andybrook.exception.*;
import com.andybrook.model.BarCode;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.orderitem.ProductItemInfo;

import java.util.List;

public interface IOrderItemService {

    List<OrderItem> createOrderItems(ProductItemInfo info, int quantityRequested);

    OrderItem createSingleItemByBarCode(BarCode barCode);

    void postDeletion(OrderItem orderItemId) throws OrderItemNotFound;

    boolean isExist(long id);
}
