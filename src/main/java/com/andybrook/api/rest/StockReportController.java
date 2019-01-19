package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.NewStockReportRequest;
import com.andybrook.manager.stock.IStockReportManager;
import com.andybrook.model.StockReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/stockReport")
public class StockReportController {

    @Autowired
    private IStockReportManager stockReportManager;

    @PostMapping(path = "/add")
    public StockReport newStockReport(@RequestBody NewStockReportRequest request) {
        return stockReportManager.newStockReport(request.getName());
    }
}
