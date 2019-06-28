package com.andybrook.manager.api;

import com.andybrook.model.api.ProductItemsFileUploadResult;

import java.io.File;
import java.io.IOException;

public interface IProductItemFileParserManager {

    ProductItemsFileUploadResult parseCsvFile(File csv) throws IOException;
}
