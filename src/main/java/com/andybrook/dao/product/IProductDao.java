package com.andybrook.dao.product;

import com.andybrook.model.product.Product;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

public interface IProductDao {

    Product save(Product product);

    Optional<Product> get(Long id);

    List<? extends Product> getByNameContaining(String name);

    Product update(Product product);

    boolean delete(long id);
}
