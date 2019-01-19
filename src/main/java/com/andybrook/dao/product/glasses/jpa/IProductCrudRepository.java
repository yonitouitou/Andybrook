package com.andybrook.dao.product.glasses.jpa;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Long> {
}
