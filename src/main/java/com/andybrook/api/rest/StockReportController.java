package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.GenericRequestById;
import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.manager.stock.IStockReportManager;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.NewStockReportRequest;
import com.andybrook.model.request.UpdateStockReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/stockReport")
public class StockReportController extends AbstractController {

    private static Logger LOGGER = System.getLogger(StockReportController.class.getSimpleName());

    @Autowired
    private IStockReportManager stockReportManager;

    @PostMapping(path = "/add")
    public StockReport newStockReport(@RequestBody NewStockReportRequest request) throws StoreNotFound {
        LOGGER.log(Level.INFO, "Add report request received : " + request.toString());
        return stockReportManager.newStockReport(request);
    }

    @PostMapping(path = "/update")
    public void updateStockReport(@RequestBody UpdateStockReportRequest request) throws OrderNotFound, StockReportClosed {
        LOGGER.log(Level.INFO, "Update report request received : " + request.toString());
        stockReportManager.updateStockReport(request);
    }

    @PostMapping(path = "/close")
    public StockReport closeStockReport(@RequestBody GenericRequestById request) throws OrderNotFound, StockReportClosed {
        LOGGER.log(Level.INFO, "Close report request received : " + request.toString());
        return stockReportManager.closeStockReport(request.getId());
    }

    @GetMapping(path = "/get/{id}")
    public StockReport get(@PathVariable Long id) throws OrderNotFound {
        LOGGER.log(Level.INFO, "Get report request received for id : " + id);
        return stockReportManager.getStockReport(id);
    }

    @GetMapping(path = "/getByName/{name}")
    public List<StockReport> getByName(@PathVariable String name) {
        LOGGER.log(Level.INFO, "Get report request received for name : " + name);
        return stockReportManager.getOrdersByNameContaining(name.trim());
    }

    @GetMapping(path = "/all")
    public Set<StockReport> getAll() {
        LOGGER.log(Level.INFO, "Get all report request received");
        return stockReportManager.getAll();
    }

}