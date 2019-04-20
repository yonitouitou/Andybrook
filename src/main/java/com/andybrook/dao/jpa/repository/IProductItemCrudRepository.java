package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.stock.ProductItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductItemCrudRepository extends CrudRepository<ProductItemEntity, Long> {
}
