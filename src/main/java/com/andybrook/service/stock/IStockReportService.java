package com.andybrook.service.stock;

import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.Product;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;

public interface IStockReportService {

    StockReport newStockReport(String name);

    void addItemToReport(long stockRepordId, StockItem<? extends Product> item) throws StockReportNotFound;
}
