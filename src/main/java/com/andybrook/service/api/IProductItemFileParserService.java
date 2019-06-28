package com.andybrook.service.api;

import com.andybrook.model.api.ProductItemsFileUploadResult;

import java.io.File;
import java.io.IOException;

public interface IProductItemFileParserService {

    ProductItemsFileUploadResult parseCsvFile(File csv) throws IOException;
}
