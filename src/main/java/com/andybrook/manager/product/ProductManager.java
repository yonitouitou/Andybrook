package com.andybrook.manager.product;

import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductManager {

    @Autowired
    private IProductService productService;

    @Override
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    @Override
    public Product getProductByBarCode(String barCodeId) {
        return productService.getByBarCode(barCodeId);
    }

    @Override
    public Product getProduct(long id) throws ProductNotFound {
        return productService.get(id);
    }

    @Override
    public List<? extends Product> getByNameContaining(String name) {
        return productService.getByNameContaining(name);
    }

    @Override
    public List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return productService.getAllProductNamesWithQuantityMoreThan(quantity);
    }
}
