package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.stock.StockReportEntity;
import com.andybrook.dao.stock.jpa.IStockReportCrudRepository;
import com.andybrook.model.StockReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StockReportDao implements IStockReportDao {

    @Autowired
    private IStockReportCrudRepository stockReportCrudRepository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public StockReport newStockReport(StockReport stockReport) {
        return updateStockReport(stockReport);
    }

    @Override
    public StockReport updateStockReport(StockReport stockReport) {
        StockReportEntity entity = entityFactory.createStockReportEntity(stockReport);
        StockReportEntity savedEntity = stockReportCrudRepository.save(entity);
        return entityFactory.createStockReport(savedEntity);
    }

    @Override
    public Optional<StockReport> getStockReport(long id) {
        Optional<StockReportEntity> stockReportEntityOpt = stockReportCrudRepository.findById(id);
        Optional<StockReport> stockReportOpt = Optional.empty();
        if (stockReportEntityOpt.isPresent()) {
            StockReport stockReport = entityFactory.createStockReport(stockReportEntityOpt.get());
            stockReportOpt = Optional.of(stockReport);
        }
        return stockReportOpt;
    }
}
