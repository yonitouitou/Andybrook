package com.andybrook.dao.jpa.crudrepository;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Long> {
}
