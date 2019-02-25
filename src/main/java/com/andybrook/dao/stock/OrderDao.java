package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.stock.StockReportEntity;
import com.andybrook.dao.jpa.crudrepository.IOrderCrudRepository;
import com.andybrook.enums.ReportStatus;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.language.LanguageResolver;
import com.andybrook.language.Msg.Error;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.UpdateStockReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderDao implements IOrderDao {

    @Autowired
    private IOrderCrudRepository orderCrudRepository;
    @Autowired
    private EntityFactory entityFactory;
    @Autowired
    private LanguageResolver languageResolver;

    @Override
    public StockReport newStockReport(StockReport stockReport) {
        return updateStockReport(stockReport);
    }

    @Override
    public StockReport updateStockReport(StockReport stockReport) {
        StockReportEntity entity = entityFactory.createStockReportEntity(stockReport);
        StockReportEntity savedEntity = orderCrudRepository.save(entity);
        return entityFactory.createStockReport(savedEntity);
    }

    @Override
    public void updateStockReport(UpdateStockReportRequest request, boolean checkIfExist) throws OrderNotFound {
        if (checkIfExist) {
            boolean isExist = orderCrudRepository.existsById(request.getId());
            if (! isExist) {
                throw new OrderNotFound(languageResolver.get(Error.STOCK_REPORT_NOT_FOUND + " : " + request.getId()));
            }
        }
        orderCrudRepository.updateExistingStockReport(request.getId(), request.getName(), request.getComment());
    }

    @Override
    public StockReport get(long id) {
        StockReportEntity entity = orderCrudRepository.getOne(id);
        return entityFactory.createStockReport(entity);
    }

    @Override
    public Optional<StockReport> findStockReport(long id) {
        Optional<StockReportEntity> stockReportEntityOpt = orderCrudRepository.findById(id);
        Optional<StockReport> stockReportOpt = Optional.empty();
        if (stockReportEntityOpt.isPresent()) {
            StockReport stockReport = entityFactory.createStockReport(stockReportEntityOpt.get());
            stockReportOpt = Optional.of(stockReport);
        }
        return stockReportOpt;
    }

    @Override
    public Set<StockReport> getAll(int limit) {
        Sort sortedByStatusAndCreationDatetime = new Sort(Direction.ASC, "status").and(new Sort(Direction.ASC, "createdDatetime"));
        Iterable<StockReportEntity> allIterable = orderCrudRepository.findAll(PageRequest.of(0, limit, sortedByStatusAndCreationDatetime));
        Set<StockReport> all = new LinkedHashSet<>();
        allIterable.forEach(entity -> {
            StockReport stockReport = entityFactory.createStockReport(entity);
            all.add(stockReport);
        });
        return all;
    }

    @Override
    public StockReport closeStockReportAndGet(long id) {
        orderCrudRepository.closeStockReport(id, ReportStatus.CLOSED, LocalDateTime.now());
        StockReportEntity entity = orderCrudRepository.getOne(id);
        return entityFactory.createStockReport(entity);
    }

    @Override
    public List<StockReport> getByName(String name) {
        List<StockReportEntity> ordersEntity = orderCrudRepository.findByName(name);
        return ordersEntity.stream()
                .map(entityFactory::createStockReport)
                .collect(Collectors.toList());
    }

    @Override
    public List<StockReport> getByNameContaining(String name) {
        List<StockReportEntity> ordersEntity = orderCrudRepository.findByNameContaining(name);
        return ordersEntity.stream()
                .map(entityFactory::createStockReport)
                .collect(Collectors.toList());
    }

    @Override
    public List<StockReport> getOrders(List<Long> ids) {
        List<StockReportEntity> ordersEntity = orderCrudRepository.findByIdIn(ids);
        return ordersEntity.stream()
                .map(entityFactory::createStockReport)
                .collect(Collectors.toList());
    }
}
