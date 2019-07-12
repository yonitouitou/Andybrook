package com.andybrook.service.api;

import com.andybrook.exception.fileupload.CsvBadFormat;
import com.andybrook.exception.fileupload.SizeFileLimitExceeded;
import com.andybrook.model.BarCode;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductItemFileParserService implements IProductItemFileParserService {

    private static Logger LOGGER = System.getLogger(ProductItemFileParserService.class.getSimpleName());
    static int LIMIT_ITEMS_BY_FILE_5000 = 5000;

    @Override
    public StockItemsFileUpload parseCsvFile(File csv) throws IOException {
        if (! csv.exists()) {
            throw new FileNotFoundException(csv.getAbsolutePath());
        }
        return processFile(csv);
    }

    private StockItemsFileUpload processFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
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
        return new StockItemsFileUpload(productItemRowsInFile, rowsProcessed, productItemsList);
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
