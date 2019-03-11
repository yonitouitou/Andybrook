package com.andybrook.dao.jpa.crudrepository;

import com.andybrook.dao.jpa.entity.stock.BarCodeEntity;
import org.springframework.data.repository.CrudRepository;

public interface IBarCodeCrudRepository extends CrudRepository<BarCodeEntity, String> {

    long getStockItemIdById(String id);
}
