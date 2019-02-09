package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.stock.StockReportEntity;
import com.andybrook.dao.jpa.crudrepository.IStockReportCrudRepository;
import com.andybrook.enums.ReportStatus;
import com.andybrook.exception.StockReportNotFound;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.UpdateStockReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

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
    public void updateStockReport(UpdateStockReportRequest request, boolean checkIfExist) throws StockReportNotFound {
        if (checkIfExist) {
            boolean isExist = stockReportCrudRepository.existsById(request.getId());
            if (! isExist) {
                throw new StockReportNotFound(request.getId());
            }
        }
        stockReportCrudRepository.updateExistingStockReport(request.getId(), request.getName(), request.getComment());
    }

    @Override
    public StockReport get(long id) {
        StockReportEntity entity = stockReportCrudRepository.getOne(id);
        return entityFactory.createStockReport(entity);
    }

    @Override
    public Optional<StockReport> findStockReport(long id) {
        Optional<StockReportEntity> stockReportEntityOpt = stockReportCrudRepository.findById(id);
        Optional<StockReport> stockReportOpt = Optional.empty();
        if (stockReportEntityOpt.isPresent()) {
            StockReport stockReport = entityFactory.createStockReport(stockReportEntityOpt.get());
            stockReportOpt = Optional.of(stockReport);
        }
        return stockReportOpt;
    }

    @Override
    public Set<StockReport> getAll() {
        Iterable<StockReportEntity> allIterable = stockReportCrudRepository.findAll(new Sort(Direction.ASC, "createdDatetime"));
        Set<StockReport> all = new LinkedHashSet<>();
        allIterable.forEach(entity -> {
            StockReport stockReport = entityFactory.createStockReport(entity);
            all.add(stockReport);
        });
        return all;
    }

    @Override
    public StockReport closeStockReportAndGet(long id) {
        stockReportCrudRepository.closeStockReport(id, ReportStatus.CLOSED, LocalDateTime.now());
        StockReportEntity entity = stockReportCrudRepository.getOne(id);
        return entityFactory.createStockReport(entity);
    }
}
