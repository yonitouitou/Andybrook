package com.andybrook.dao.product;

import com.andybrook.model.product.Product;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findByNameContaining(String name);

    Optional<Product> findByName(String name);
}
