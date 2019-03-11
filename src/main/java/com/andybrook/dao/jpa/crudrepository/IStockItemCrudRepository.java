package com.andybrook.dao.jpa.crudrepository;

import com.andybrook.dao.jpa.entity.stock.StockItemEntity;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface IStockItemCrudRepository extends CrudRepository<StockItemEntity, Long> {

}
