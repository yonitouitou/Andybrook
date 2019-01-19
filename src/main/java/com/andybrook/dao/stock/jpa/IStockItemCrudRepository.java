package com.andybrook.dao.stock.jpa;

import com.andybrook.dao.jpa.entity.stock.StockItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface IStockItemCrudRepository extends CrudRepository<StockItemEntity, Long> {

}
