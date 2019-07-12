package com.andybrook.dao.stock;

import com.andybrook.model.api.StockItemsFileUpload;

public interface IProductFileUploadDao {

    String saveProductFileUpload(StockItemsFileUpload upload);
}
