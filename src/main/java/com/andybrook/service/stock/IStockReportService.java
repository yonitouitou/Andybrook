package com.andybrook.service.stock;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;

import java.util.Set;

public interface IStockReportService {

    StockReport newStockReport(NewStockReportRequest request);

    void updateStockReport(UpdateStockReportRequest request) throws StockReportNotFound, StockReportClosed;

    StockReport getStockReport(long id) throws StockReportNotFound;

    Set<StockReport> getAll();

    void addItemToReport(long stockRepordId, StockItem<? extends Product> item) throws StockReportNotFound;

    StockReport closeStockReport(long id) throws StockReportNotFound, StockReportClosed;
}
