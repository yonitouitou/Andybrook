package com.andybrook.dao.product;

import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;

import java.util.List;
import java.util.Optional;

public interface IProductDao {

    void save(Product product);

    Optional<Product> get(ProductId id);

    Optional<Product> getByName(String name);

    boolean isExist(ProductId id);

    List<Product> getByNameContaining(String name);

    boolean delete(ProductId id);
}
