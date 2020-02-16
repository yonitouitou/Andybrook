package com.andybrook.service.api;

import com.andybrook.ApplicationProperties;
import com.andybrook.dao.stock.IStockItemsFileUploadDao;
import com.andybrook.enums.ProductType;
import com.andybrook.exception.ValidationRuntimeException;
import com.andybrook.exception.fileupload.CsvBadFormat;
import com.andybrook.exception.fileupload.EmptyFileException;
import com.andybrook.exception.fileupload.SizeFileLimitExceeded;
import com.andybrook.model.BarCode;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.model.api.StockItemsFileUpload.ProductToUpload;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.product.IProductService;
import com.andybrook.service.stock.IStockService;
import com.andybrook.util.clock.Clock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockItemsFileParserService implements IStockItemsFileParserService {

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private IStockItemsFileUploadDao dao;
    @Autowired
    private IStockService stockService;
    @Autowired
    private IProductService productService;

    private static Logger LOGGER = System.getLogger(StockItemsFileParserService.class.getSimpleName());

    @Override
    public StockItemsFileUpload processCsvFile(File csv) throws IOException {
        if (! csv.exists()) {
            throw new FileNotFoundException(csv.getAbsolutePath());
        }
        StockItemsFileUpload stockItemsFileUpload = parseFile(csv);
        String id = dao.saveProductFileUpload(stockItemsFileUpload);
        stockItemsFileUpload.setId(id);
        return stockItemsFileUpload;
    }

    @Override
    public void processUpload(String uploadId) {
        Optional<StockItemsFileUpload> fileUploadOpt = dao.getById(uploadId);
        if (fileUploadOpt.isPresent()) {
            StockItemsFileUpload fileUpload = fileUploadOpt.get();
            for (ProductToUpload item : fileUpload.getProductsForUpload()) {
                try {
                    Product product = getOrCreateProductByName(ProductType.GLASSES, item.getName());
                    ProductItem productItem = new ProductItem(product, item.getBarCode());
                    stockService.addProductItem(productItem);
                } catch (Exception e) {
                    LOGGER.log(Level.ERROR, "ProductItem " + item.getName() + " not added because error occurred", e);
                }
            }
        } else {
            throw new StockItemsUploadNotFound(uploadId);
        }
    }

    StockItemsFileUpload parseFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        if (lines.isEmpty()) {
            throw new EmptyFileException();
        }
        int productItemRowsInFile = lines.size() - 1;
        int rowsProcessed = 0;
        List<ProductToUpload> productItemsList = new ArrayList<>(productItemRowsInFile);
        for (int i = 1; i < lines.size(); i++) {
            try {
                addProductForUpload(productItemsList, lines.get(i));
                rowsProcessed++;
            } catch (CsvBadFormat e) {
                LOGGER.log(Level.ERROR, "Bad Csv row : " + lines.get(i), e);
            } catch (SizeFileLimitExceeded e) {
                break;
            }
        }
        return new StockItemsFileUpload(null, productItemRowsInFile, rowsProcessed, productItemsList, Clock.millis());
    }

    private Product getOrCreateProductByName(ProductType productType, String productName) {
        Product product = productService.getByName(productType, productName);
        if (product == null) {
            productService.add(product);
        }
        return product;
    }

    private void addProductForUpload(List<ProductToUpload> items, String line) throws CsvBadFormat, SizeFileLimitExceeded {
        try {
            String[] parts = line.split(";");
            if (parts.length == 3) {
                String[] barCodeStr = parts[2].split(",");
                for (String bc : barCodeStr) {
                    if (items.size() == applicationProperties.getStockItemFileUploadLimitItems()) {
                        throw new SizeFileLimitExceeded("Limit ProductItem by file : " + applicationProperties.getStockItemFileUploadLimitItems());
                    }
                    items.add(new ProductToUpload(parts[0], Double.parseDouble(parts[1]), new BarCode(bc)));
                }
            } else {
                throw new CsvBadFormat(line);
            }
        } catch (SizeFileLimitExceeded e) {
            throw e;
        } catch (Exception e) {
            throw new CsvBadFormat(line);
        }
    }

    private static class StockItemsUploadNotFound extends ValidationRuntimeException {

        public StockItemsUploadNotFound(String uploadId) {
            super(uploadId);
        }
    }
}
