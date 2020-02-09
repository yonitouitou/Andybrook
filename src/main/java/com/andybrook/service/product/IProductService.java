package com.andybrook.service.product;

import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    void add(Product product);

    Product get(ProductId id);

    boolean isExist(ProductId id);

    Optional<Product> getByName(String name);

    List<Product> getByNameContaining(String subName);
}
