package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findByNameContaining(String name);
}
