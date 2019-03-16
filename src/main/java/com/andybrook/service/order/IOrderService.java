package com.andybrook.service.order;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.model.request.UpdateOrderRequest;

import java.util.List;
import java.util.Set;

public interface IOrderService {

    StockReport newOrder(NewOrderRequest request) throws StoreNotFound;

    void updateOrder(UpdateOrderRequest request) throws OrderNotFound, OrderClosed;

    StockReport getOrder(long id) throws OrderNotFound;

    Set<StockReport> getAll();

    StockItem<? extends Product> addItemToOrder(long stockRepordId, StockItem<? extends Product> item) throws OrderNotFound, OrderClosed;

    StockReport closeStockReport(long id) throws OrderNotFound, OrderClosed;

    List<StockReport> getOrdersByName(String name);

    List<StockReport> getOrderByNameContaining(String name);

    List<StockReport> getOrders(List<Long> ids);

    boolean canModifyOrder(long id) throws OrderNotFound;

    boolean canModifyOrder(StockReport order);
}
