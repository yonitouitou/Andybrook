package com.andybrook.api.rest;

import com.andybrook.manager.stock.IStockManager;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ProductStockInfo getProductStockInfo(@PathVariable String productId) {
        LOGGER.log(Level.INFO, "Get product stock info for product : " + productId);
        return stockManager.getProductStockInfo(ProductId.from(productId));
    }

    @GetMapping(path = "/productItemByBarCode/{barCode}")
    public ProductItem getProductStockInfoByBarCode(@PathVariable String barCode) {
        LOGGER.log(Level.INFO, "Get product item by barCode : " + barCode);
        return stockManager.getProductItemByBarCodeId(new BarCode(barCode));
    }

    @GetMapping(path = "/getAllExistingProductNames")
    public List<ProductStockInfo> getAllProductNames() {
        LOGGER.log(Level.INFO, "Get all products name with quantity > 0");
        return stockManager.getAllProductNamesWithQuantityMoreThan(0);
    }
}
