package com.andybrook.api.rest;

import com.andybrook.exception.BarCodeAlreadyExist;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.manager.product.IProductManager;
import com.andybrook.model.BarCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

@RestController
@RequestMapping("v1/product")
public class ProductController extends AbstractController {

    private static Logger LOGGER = System.getLogger(StockItemController.class.getSimpleName());

    @Autowired
    private IProductManager productManager;

    @PostMapping(path = "/addBarcode")
    public void addBarCode(long stockItemId, BarCode barCode) throws ProductNotFound, BarCodeAlreadyExist {
        LOGGER.log(Level.INFO, "Request received to add barcode " + barCode.getId() + "to : " + stockItemId);
        productManager.addBarCode(stockItemId, barCode);
    }
}
