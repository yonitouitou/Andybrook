package com.andybrook.dao.stock.jpa;

import com.andybrook.dao.jpa.entity.stock.StockReportEntity;
import org.springframework.data.repository.CrudRepository;

public interface IStockReportCrudRepository extends CrudRepository<StockReportEntity, Long> {
}
