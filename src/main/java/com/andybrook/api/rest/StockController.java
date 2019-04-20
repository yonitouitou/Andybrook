package com.andybrook.api.rest;

import com.andybrook.manager.stock.IStockManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;

@RestController
@RequestMapping("v1/stock")
public class StockController extends AbstractController {

    private static Logger LOGGER = System.getLogger(StockController.class.getSimpleName());

    @Autowired
    private IStockManager stockManager;

    @GetMapping(path = "/getAllExistingProductNames")
    public List<Pair<Long, String>> getAllProductNames() {
        LOGGER.log(Level.INFO, "Get all products name with quantity > 0");
        return stockManager.getAllProductNamesWithQuantityMoreThan(0);
    }
}
