package com.andybrook.dao.stock;

import com.andybrook.exception.fileupload.StockItemsFileUploadException;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.serialization.ISerializer;
import com.andybrook.serialization.jackson.JacksonSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StockItemsFileUploadDao implements IStockItemsFileUploadDao {

    private static System.Logger LOGGER = System.getLogger(StockItemsFileUploadDao.class.getSimpleName());
    private static final ISerializer SERIALIZER = new JacksonSerializer();
    private static final String INDEX_NAME = "stock_items_file_upload";

    @Autowired
    private IStockItemsFileUploadRepository repository;

    @Override
    public String saveProductFileUpload(StockItemsFileUpload upload) {
        StockItemsFileUpload persisted = repository.save(upload);
        return persisted.getId();
    }

    @Override
    public StockItemsFileUpload getById(String uploadId) {
        Optional<StockItemsFileUpload> fileUploadOpt = repository.findById(uploadId);
        return fileUploadOpt.get();
    }

    private class StockItemsFileUploadSaveException extends StockItemsFileUploadException {
        public StockItemsFileUploadSaveException(Throwable cause) {
            super(cause);
        }
    }
    private class StockItemsFileUploadGetException extends StockItemsFileUploadException {}
}
