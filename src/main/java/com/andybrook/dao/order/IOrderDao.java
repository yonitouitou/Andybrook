package com.andybrook.dao.order;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.UpdateOrderRequest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IOrderDao {

    StockReport newStockReport(StockReport stockReport);

    StockReport updateOrder(StockReport stockReport);

    void updateOrder(UpdateOrderRequest request, boolean checkIfExist) throws OrderNotFound;

    StockReport get(long id);

    Optional<StockReport> findStockReport(long id);

    Set<StockReport> getAll(int limit);

    List<StockReport> getByName(String name);

    List<StockReport> getByNameContaining(String name);

    List<StockReport> getOrders(List<Long> ids);
}
