package com.andybrook.manager.product;

import com.andybrook.enums.ProductType;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;

import java.util.List;

public interface IProductManager {

    void addProduct(Product product);

    List<? extends Product> getByNameContaining(ProductType productType, String name);

    Product getProduct(ProductId id) throws ProductNotFound;
}
