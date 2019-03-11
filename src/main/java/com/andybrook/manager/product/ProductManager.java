package com.andybrook.manager.product;

import com.andybrook.exception.BarCodeAlreadyExist;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductManager implements IProductManager {

    @Autowired
    private IProductService productService;

    @Override
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    @Override
    public void addBarCode(long productId, BarCode barCode) throws BarCodeAlreadyExist, ProductNotFound {
        Objects.requireNonNull(barCode);
        productService.addBarCode(productId, barCode);
    }
}
