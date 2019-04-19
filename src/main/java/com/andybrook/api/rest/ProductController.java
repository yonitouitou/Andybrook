package com.andybrook.api.rest;

import com.andybrook.exception.BarCodeAlreadyExist;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.manager.product.IProductManager;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController extends AbstractController {

    private static Logger LOGGER = System.getLogger(ProductController.class.getSimpleName());

    @Autowired
    private IProductManager productManager;

    @GetMapping(path = "/get/{id}")
    public Product get(@PathVariable long id) throws ProductNotFound {
        LOGGER.log(Level.INFO, "Get Product by id : " + id);
        return productManager.getProduct(id);
    }

    @GetMapping(path = "/getByBarCode/{barCodeId}")
    public Product get(@PathVariable String barCodeId) {
        LOGGER.log(Level.INFO, "Get Product by barCodeId : " + barCodeId);
        return productManager.getProductByBarCode(barCodeId);
    }

    @GetMapping(path = "/getByNameContaining/{name}")
    public List<? extends Product> getAll(@PathVariable String name) {
        LOGGER.log(Level.INFO, "Get all products request by subname : " + name);
        return productManager.getByNameContaining(name);
    }

    @GetMapping(path = "/getAllExistingProductNames")
    public List<Pair<Long, String>> getAllProductNames() {
        LOGGER.log(Level.INFO, "Get all products name");
        return productManager.getAllProductNamesWithQuantityMoreThan(0);
    }

    @PostMapping(path = "/addBarcode")
    public void addBarCode(long stockItemId, BarCode barCode) throws ProductNotFound, BarCodeAlreadyExist {
        LOGGER.log(Level.INFO, "Request received to add barcode " + barCode.getId() + "to : " + stockItemId);
        productManager.addBarCode(stockItemId, barCode);
    }
}
