package com.andybrook.service.api;

import com.andybrook.ApplicationProperties;
import com.andybrook.dao.stock.IStockItemsFileUploadDao;
import com.andybrook.exception.fileupload.CsvBadFormat;
import com.andybrook.exception.fileupload.EmptyFileException;
import com.andybrook.exception.fileupload.SizeFileLimitExceeded;
import com.andybrook.model.BarCode;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.product.IProductService;
import com.andybrook.service.product.ProductService;
import com.andybrook.service.stock.IStockService;
import com.andybrook.util.IdGenerator;
import com.andybrook.util.clock.Clock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    static int LIMIT_ITEMS_BY_FILE_5000 = 5000;

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
        StockItemsFileUpload fileUpload = dao.getById(uploadId);
        for (ProductItem item : fileUpload.getProductItems()) {
            try {
                Product product = getOrCreateProduct(item.getProduct());
                item.setProduct(product);
                stockService.addProductItem(item, false);
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, "ProductItem " + item.getName() + " not added because error occurred", e);
            }
        }
    }

    StockItemsFileUpload parseFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        if (lines.isEmpty()) {
            throw new EmptyFileException();
        }
        int productItemRowsInFile = lines.size() - 1;
        int rowsProcessed = 0;
        List<ProductItem> productItemsList = new ArrayList<>(productItemRowsInFile);
        for (int i = 1; i < lines.size(); i++) {
            try {
                addProductItems(productItemsList, lines.get(i));
                rowsProcessed++;
            } catch (CsvBadFormat e) {
                LOGGER.log(Level.ERROR, "Bad Csv row : " + lines.get(i), e);
            } catch (SizeFileLimitExceeded e) {
                break;
            }
        }
        return new StockItemsFileUpload(null, productItemRowsInFile, rowsProcessed, productItemsList, Clock.millis());
    }

    private Product getOrCreateProduct(Product product) {
        Optional<Product> productOpt = productService.getByName(product.getName());
        return productOpt.orElseGet(() -> productService.addProduct(product));
    }

    private void addProductItems(List<ProductItem> items, String line) throws CsvBadFormat, SizeFileLimitExceeded {
        try {
            String[] parts = line.split(";");
            if (parts.length == 3) {
                Product product = new Glasses(IdGenerator.generateId(), parts[0], Double.parseDouble(parts[1]));
                String[] barCodeStr = parts[2].split(",");
                for (String bc : barCodeStr) {
                    if (items.size() == LIMIT_ITEMS_BY_FILE_5000) {
                        throw new SizeFileLimitExceeded("Limit ProductItem by file : " + LIMIT_ITEMS_BY_FILE_5000);
                    }
                    items.add(new ProductItem(product, new BarCode(bc)));
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
}
