package com.andybrook.dao.stock.barcode;

import com.andybrook.model.BarCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BarCodeDao implements IBarCodeDao {

    @Autowired
    private IBarCodeRepository repository;

    @Override
    public boolean isExist(String id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<BarCode> get(String id) {
        return repository.findById(id);
    }

    @Override
    public void save(BarCode barCode) {
        repository.save(barCode);
    }
}
