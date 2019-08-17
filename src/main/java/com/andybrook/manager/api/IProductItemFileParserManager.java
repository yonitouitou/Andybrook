package com.andybrook.manager.api;

import com.andybrook.model.api.StockItemsFileUpload;

import java.io.File;
import java.io.IOException;

public interface IProductItemFileParserManager {

    StockItemsFileUpload parseCsvFile(File csv) throws IOException;

    void processUpload(String uploadId);
}
