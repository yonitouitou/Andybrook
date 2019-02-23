package com.andybrook.dao.stock;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.UpdateStockReportRequest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IStockReportDao {

    StockReport newStockReport(StockReport stockReport);

    StockReport updateStockReport(StockReport stockReport);

    void updateStockReport(UpdateStockReportRequest request, boolean checkIfExist) throws OrderNotFound;

    StockReport get(long id);

    Optional<StockReport> findStockReport(long id);

    Set<StockReport> getAll(int limit);

    StockReport closeStockReportAndGet(long id);

    List<StockReport> getByName(String name);

    List<StockReport> getByNameContaining(String name);

    List<StockReport> getOrders(List<Long> ids);
}
