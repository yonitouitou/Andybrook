package com.andybrook.dao.stock.jpa;

import com.andybrook.dao.jpa.entity.stock.StockItemEntity;
import com.andybrook.model.Product;
import com.andybrook.model.StockItem;

import java.util.Optional;

public class StockReportCrudRepository implements IStockItemCrudRepository {

    @Override
    public <S extends StockItemEntity> S save(S s) {
        return save(s);
    }

    /*@Override
    public void addItemToReport(long reportId, StockItem<? extends Product> item) {

    }*/

    @Override
    public <S extends StockItemEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return saveAll(iterable);
    }

    @Override
    public Optional<StockItemEntity> findById(Long aLong) {
        return findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return existsById(aLong);
    }

    @Override
    public Iterable<StockItemEntity> findAll() {
        return findAll();
    }

    @Override
    public Iterable<StockItemEntity> findAllById(Iterable<Long> iterable) {
        return findAllById(iterable);
    }

    @Override
    public long count() {
        return count();
    }

    @Override
    public void deleteById(Long aLong) {
        deleteById(aLong);
    }

    @Override
    public void delete(StockItemEntity stockItemEntity) {
        delete(stockItemEntity);
    }

    @Override
    public void deleteAll(Iterable<? extends StockItemEntity> iterable) {
        deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        deleteAll();
    }
}
