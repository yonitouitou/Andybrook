package com.andybrook.manager.api;

import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.service.api.IProductItemFileParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ProductItemFileParserManager implements IProductItemFileParserManager {

    @Autowired
    private IProductItemFileParserService productItemFileParserService;

    @Override
    public StockItemsFileUpload parseCsvFile(File csv) throws IOException {
        return productItemFileParserService.parseCsvFile(csv);
    }
}
