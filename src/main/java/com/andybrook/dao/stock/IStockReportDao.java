package com.andybrook.dao.stock;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.UpdateStockReportRequest;

import java.util.Optional;
import java.util.Set;

public interface IStockReportDao {

    StockReport newStockReport(StockReport stockReport);

    StockReport updateStockReport(StockReport stockReport);

    void updateStockReport(UpdateStockReportRequest request, boolean checkIfExist) throws StockReportNotFound;

    Optional<StockReport> getStockReport(long id);

    Set<StockReport> getAll();

    void closeStockReport(long id);
}
