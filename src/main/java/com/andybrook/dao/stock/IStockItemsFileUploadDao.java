package com.andybrook.dao.stock;

import com.andybrook.model.api.StockItemsFileUpload;

import java.util.Optional;

public interface IStockItemsFileUploadDao {

    String saveProductFileUpload(StockItemsFileUpload upload);

    Optional<StockItemsFileUpload> getById(String uploadId);
}
