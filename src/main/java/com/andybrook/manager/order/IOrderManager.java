package com.andybrook.manager.order;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.model.request.UpdateOrderRequest;
import com.andybrook.model.StockReport;

import java.util.List;
import java.util.Set;

public interface IOrderManager {

    StockReport newOrder(NewOrderRequest request) throws StoreNotFound;

    void updateStockReport(UpdateOrderRequest updateRequest) throws OrderNotFound, OrderClosed;

    StockReport getOrder(long id) throws OrderNotFound;

    Set<StockReport> getAll();

    StockReport closeOrder(long id) throws OrderNotFound, OrderClosed;

    List<StockReport> getOrdersByName(String name);

    List<StockReport> getOrdersByNameContaining(String name);

    List<StockReport> getOrders(List<Long> ids);
}
