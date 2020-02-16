package com.andybrook.manager.product;

import com.andybrook.enums.ProductType;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.service.product.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductManager {

    @Autowired
    private IProductService productService;

    @Override
    public void addProduct(Product product) {
        productService.add(product);
    }

    @Override
    public Product getProduct(ProductId id) throws ProductNotFound {
        return productService.get(id);
    }

    @Override
    public List<? extends Product> getByNameContaining(ProductType productType, String name) {
        return productService.getByNameContaining(productType, name);
    }
}
