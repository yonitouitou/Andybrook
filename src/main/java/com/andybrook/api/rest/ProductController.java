package com.andybrook.api.rest;

import com.andybrook.exception.BarCodeAlreadyExist;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.manager.product.IProductManager;
import com.andybrook.manager.stock.IStockManager;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController extends AbstractController {

    private static Logger LOGGER = System.getLogger(ProductController.class.getSimpleName());

    @Autowired
    private IProductManager productManager;
    @Autowired
    private IStockManager stockManager;

    @GetMapping(path = "/get/{id}")
    public Product get(@PathVariable long id) throws ProductNotFound {
        LOGGER.log(Level.INFO, "Get Product by id : " + id);
        return productManager.getProduct(new ProductId(id));
    }

    @GetMapping(path = "/getByBarCode/{barCodeId}")
    public Product get(@PathVariable String barCodeId) {
        LOGGER.log(Level.INFO, "Get Product by barCodeId : " + barCodeId);
        ProductItem productItem = stockManager.getProductItemByBarCodeId(new BarCode(barCodeId));
        return productManager.getProduct(productItem.getProductId());
    }

    @GetMapping(path = "/getAvailableByNameContaining/{name}")
    public List<? extends Product> getAll(@PathVariable String name) {
        LOGGER.log(Level.INFO, "Get all available products request by subname : " + name);
        return productManager.getByNameContaining(name);
    }

    @PostMapping(path = "/addBarcode")
    public void addBarCode(long stockItemId, BarCode barCode) throws ProductNotFound, BarCodeAlreadyExist {
        LOGGER.log(Level.INFO, "Request received to add barcode " + barCode.get() + "to : " + stockItemId);
        //productManager.addBarCode(stockItemId, barCode);
    }
}
