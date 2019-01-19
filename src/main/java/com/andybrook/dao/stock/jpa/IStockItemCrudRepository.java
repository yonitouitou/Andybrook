package com.andybrook.dao.stock.jpa;

import com.andybrook.dao.jpa.entity.stock.StockItemEntity;
import com.andybrook.model.Product;
import com.andybrook.model.StockItem;
import org.springframework.data.repository.CrudRepository;

public interface IStockItemCrudRepository extends CrudRepository<StockItemEntity, Long> {

    void addItemToReport(long reportId, StockItem<? extends Product> item);
}
