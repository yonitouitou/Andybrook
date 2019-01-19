package com.andybrook.dao.stock;

import com.andybrook.model.StockReport;

import java.util.Optional;

public interface IStockReportDao {

    StockReport newStockReport(StockReport stockReport);

    StockReport updateStockReport(StockReport stockReport);

    Optional<StockReport> getStockReport(long id);
}
