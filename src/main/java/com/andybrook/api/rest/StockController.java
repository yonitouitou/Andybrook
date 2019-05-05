package com.andybrook.api.rest;

import com.andybrook.manager.stock.IStockManager;
import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "/productStockInfo/{productId}")
    public ProductStockInfo getProductStockInfo(@PathVariable long productId) {
        LOGGER.log(Level.INFO, "Get product stock info for product : " + productId);
        return stockManager.getProductStockInfo(productId);
    }

    @GetMapping(path = "/productStockInfoByBarCode/{barCode}")
    public ProductStockInfo getProductStockInfo(@PathVariable String barCode) {
        LOGGER.log(Level.INFO, "Get product stock info for barCode : " + barCode);
        return stockManager.getProductStockInfoByBarCodeId(barCode);
    }

    @GetMapping(path = "/getAllExistingProductNames")
    public List<Pair<Long, String>> getAllProductNames() {
        LOGGER.log(Level.INFO, "Get all products name with quantity > 0");
        return stockManager.getAllProductNamesWithQuantityMoreThan(0);
    }
}
