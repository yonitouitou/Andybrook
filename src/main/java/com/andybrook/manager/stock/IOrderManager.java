package com.andybrook.manager.stock;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import com.andybrook.model.StockReport;

import java.util.List;
import java.util.Set;

public interface IOrderManager {

    StockReport newStockReport(NewStockReportRequest request) throws StoreNotFound;

    void updateStockReport(UpdateStockReportRequest updateRequest) throws OrderNotFound, StockReportClosed;

    StockReport getStockReport(long id) throws OrderNotFound;

    Set<StockReport> getAll();

    StockReport closeStockReport(long id) throws OrderNotFound, StockReportClosed;

    List<StockReport> getOrdersByName(String name);

    List<StockReport> getOrdersByNameContaining(String name);

    List<StockReport> getOrders(List<Long> ids);
}
