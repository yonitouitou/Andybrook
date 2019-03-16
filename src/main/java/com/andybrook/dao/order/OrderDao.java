package com.andybrook.dao.order;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.stock.OrderEntity;
import com.andybrook.dao.jpa.crudrepository.IOrderCrudRepository;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.language.LanguageResolver;
import com.andybrook.language.Msg.Error;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.UpdateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

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
        return updateOrder(stockReport);
    }

    @Override
    public StockReport updateOrder(StockReport stockReport) {
        OrderEntity entity = entityFactory.createOrderEntity(stockReport);
        OrderEntity savedEntity = orderCrudRepository.save(entity);
        return entityFactory.createOrder(savedEntity);
    }

    @Override
    public void updateOrder(UpdateOrderRequest request, boolean checkIfExist) throws OrderNotFound {
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
        OrderEntity entity = orderCrudRepository.getOne(id);
        return entityFactory.createOrder(entity);
    }

    @Override
    public Optional<StockReport> findStockReport(long id) {
        Optional<OrderEntity> stockReportEntityOpt = orderCrudRepository.findById(id);
        Optional<StockReport> stockReportOpt = Optional.empty();
        if (stockReportEntityOpt.isPresent()) {
            StockReport stockReport = entityFactory.createOrder(stockReportEntityOpt.get());
            stockReportOpt = Optional.of(stockReport);
        }
        return stockReportOpt;
    }

    @Override
    public Set<StockReport> getAll(int limit) {
        Sort sortedByStatusAndCreationDatetime = new Sort(Direction.ASC, "status").and(new Sort(Direction.ASC, "createdDatetime"));
        Iterable<OrderEntity> allIterable = orderCrudRepository.findAll(PageRequest.of(0, limit, sortedByStatusAndCreationDatetime));
        Set<StockReport> all = new LinkedHashSet<>();
        allIterable.forEach(entity -> {
            StockReport stockReport = entityFactory.createOrder(entity);
            all.add(stockReport);
        });
        return all;
    }

    @Override
    public List<StockReport> getByName(String name) {
        List<OrderEntity> ordersEntity = orderCrudRepository.findByName(name);
        return ordersEntity.stream()
                .map(entityFactory::createOrder)
                .collect(Collectors.toList());
    }

    @Override
    public List<StockReport> getByNameContaining(String name) {
        List<OrderEntity> ordersEntity = orderCrudRepository.findByNameContaining(name);
        return ordersEntity.stream()
                .map(entityFactory::createOrder)
                .collect(Collectors.toList());
    }

    @Override
    public List<StockReport> getOrders(List<Long> ids) {
        List<OrderEntity> ordersEntity = orderCrudRepository.findByIdIn(ids);
        return ordersEntity.stream()
                .map(entityFactory::createOrder)
                .collect(Collectors.toList());
    }
}
