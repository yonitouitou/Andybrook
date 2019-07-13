package com.andybrook.service.api;

import com.andybrook.model.api.StockItemsFileUpload;

import java.io.File;
import java.io.IOException;

public interface IStockItemsFileParserService {

    StockItemsFileUpload processCsvFile(File csv) throws IOException;
}
