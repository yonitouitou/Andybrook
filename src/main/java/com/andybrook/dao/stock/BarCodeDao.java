package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.crudrepository.IBarCodeCrudRepository;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.stock.BarCodeEntity;
import com.andybrook.model.BarCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BarCodeDao implements IBarCodeDao {

    @Autowired
    private IBarCodeCrudRepository crudRepository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public boolean isExist(String id) {
        return crudRepository.existsById(id);
    }

    @Override
    public Optional<BarCode> get(String id) {
        Optional<BarCode> barCodeOpt = Optional.empty();
        Optional<BarCodeEntity> entityOpt = crudRepository.findById(id);
        if (entityOpt.isPresent()) {
            barCodeOpt = Optional.of(entityFactory.createBarCode(entityOpt.get()));
        }
        return barCodeOpt;
    }

    @Override
    public long getStockItemIdByBarCodeId(String id) {
        return getStockItemIdByBarCodeId(id);
    }

    @Override
    public BarCode save(BarCode barCode) {
        BarCodeEntity entity = entityFactory.createBarCodeEntity(barCode);
        BarCodeEntity savedEntity = crudRepository.save(entity);
        return entityFactory.createBarCode(savedEntity);
    }
}
