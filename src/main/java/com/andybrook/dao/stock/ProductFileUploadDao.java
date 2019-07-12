package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.stock.StockItemFileUploadEntity;
import com.andybrook.model.api.StockItemsFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductFileUploadDao implements IProductFileUploadDao {

    @Autowired
    private IProductFileUploadRepository repository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public String saveProductFileUpload(StockItemsFileUpload upload) {
        StockItemFileUploadEntity entity = entityFactory.createStockItemFileUploadEntity(upload);
        StockItemFileUploadEntity saved = repository.save(entity);
        return "";
    }
}
