package com.andybrook.dao.product.glasses;

import com.andybrook.model.product.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDao {

    Product save(Product product);

    Optional<Product> get(Long id);

    List<? extends Product> getByNameContaining(String name);

    List<String> getAllProductNamesWithQuantityMoreThan(int quantity);

    Product update(Product product);

    boolean delete(long id);
}
