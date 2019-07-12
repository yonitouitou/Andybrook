package com.andybrook.service.api;

import com.andybrook.model.api.StockItemsFileUpload;

import java.io.File;
import java.io.IOException;

public interface IProductItemFileParserService {

    StockItemsFileUpload parseCsvFile(File csv) throws IOException;
}
