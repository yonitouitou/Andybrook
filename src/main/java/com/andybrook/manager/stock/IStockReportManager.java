package com.andybrook.manager.stock;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import com.andybrook.model.StockReport;

import java.util.Set;

public interface IStockReportManager {

    StockReport newStockReport(NewStockReportRequest request) throws StoreNotFound;

    void updateStockReport(UpdateStockReportRequest updateRequest) throws StockReportNotFound, StockReportClosed;

    StockReport getStockReport(long id) throws StockReportNotFound;

    Set<StockReport> getAll();

    StockReport closeStockReport(long id) throws StockReportNotFound, StockReportClosed;
}
