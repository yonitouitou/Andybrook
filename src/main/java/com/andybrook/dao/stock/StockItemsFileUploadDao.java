package com.andybrook.dao.stock;

import com.andybrook.model.api.StockItemsFileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StockItemsFileUploadDao implements IStockItemsFileUploadDao {

    @Autowired
    private IStockItemsFileUploadRepository repository;

    @Override
    public String saveProductFileUpload(StockItemsFileUpload upload) {
        StockItemsFileUpload persisted = repository.save(upload);
        return persisted.getId();
    }

    @Override
    public Optional<StockItemsFileUpload> getById(String uploadId) {
        return repository.findById(uploadId);
    }
}
