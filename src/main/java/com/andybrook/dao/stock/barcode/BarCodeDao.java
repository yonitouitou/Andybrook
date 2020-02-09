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
    public boolean isExist(BarCode barCode) {
        return repository.existsById(barCode.get());
    }

    @Override
    public Optional<BarCode> get(BarCode barCode) {
        return repository.findById(barCode.get());
    }

    @Override
    public void save(BarCode barCode) {
        repository.save(barCode);
    }
}
