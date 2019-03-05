package com.andybrook.service.stock;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;

import java.util.List;
import java.util.Set;

public interface IOrderService {

    StockReport newStockReport(NewStockReportRequest request) throws StoreNotFound;

    void updateStockReport(UpdateStockReportRequest request) throws OrderNotFound, OrderClosed;

    StockReport getOrder(long id) throws OrderNotFound;

    Set<StockReport> getAll();

    void addItemToReport(long stockRepordId, StockItem<? extends Product> item) throws OrderNotFound;

    StockReport closeStockReport(long id) throws OrderNotFound, OrderClosed;

    List<StockReport> getOrdersByName(String name);

    List<StockReport> getOrderByNameContaining(String name);

    List<StockReport> getOrders(List<Long> ids);

    boolean canModifyOrder(long id) throws OrderNotFound;
}
