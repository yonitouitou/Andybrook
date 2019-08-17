package com.andybrook.service.product;

import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.product.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product get(long id) throws ProductNotFound;

    Optional<Product> getByName(String name);

    boolean isExist(long id);

    Product getByBarCode(String barCodeId);

    Product update(Product product);

    List<? extends Product> getByNameContaining(String subName);

    Product addProduct(Product product);
}
