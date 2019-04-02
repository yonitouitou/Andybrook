package com.andybrook.manager.product;

import com.andybrook.exception.BarCodeAlreadyExist;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;

import java.util.List;

public interface IProductManager {

    Product addProduct(Product product);

    List<? extends Product> getByNameContaining(String name);

    void addBarCode(long productId, BarCode barCode) throws BarCodeAlreadyExist, ProductNotFound;

    List<String> getAllProductNamesWithQuantityMoreThan(int quantity);
}
