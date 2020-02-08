package com.andybrook.manager.product;

import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;

import java.util.List;

public interface IProductManager {

    void addProduct(Product product);

    Product getProductByBarCode(BarCode barCode);

    List<? extends Product> getByNameContaining(String name);

    Product getProduct(ProductId id) throws ProductNotFound;
}
