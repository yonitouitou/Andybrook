package com.andybrook.dao.jpa.crudrepository;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.dao.jpa.entity.stock.BarCodeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IBarCodeCrudRepository extends CrudRepository<BarCodeEntity, String> {
}
