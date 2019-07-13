package com.andybrook.dao.stock;

import com.andybrook.model.api.StockItemsFileUpload;

public interface IStockItemsFileUploadDao {

    String saveProductFileUpload(StockItemsFileUpload upload);
}
