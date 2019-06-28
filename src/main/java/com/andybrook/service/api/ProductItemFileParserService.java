package com.andybrook.service.api;

import com.andybrook.exception.CsvBadFormat;
import com.andybrook.model.BarCode;
import com.andybrook.model.api.ProductItemsFileUploadResult;
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

    @Override
    public ProductItemsFileUploadResult parseCsvFile(File csv) throws IOException {
        if (! csv.exists()) {
            throw new FileNotFoundException(csv.getAbsolutePath());
        }
        return processFile(csv);
    }

    private ProductItemsFileUploadResult processFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int productItemRowsInFile = lines.size() - 1;
        int rowsProcessed = 0;
        List<ProductItem> productItems = new ArrayList<>(productItemRowsInFile);
        for (int i = 1; i < lines.size(); i++) {
            try {
                List<ProductItem> items = createProductItems(lines.get(i));
                productItems.addAll(items);
                rowsProcessed++;
            } catch (CsvBadFormat e) {
                LOGGER.log(Level.ERROR, "Bad Csv row : " + lines.get(i), e);
            }
        }
        return new ProductItemsFileUploadResult(productItemRowsInFile, rowsProcessed, productItems);
    }

    private List<ProductItem> createProductItems(String line) throws CsvBadFormat {
        List<ProductItem> productItems = new ArrayList<>();
        try {
            String[] parts = line.split(";");
            if (parts.length == 3) {
                Product product = new Glasses(IdGenerator.generateId(), parts[0], Double.parseDouble(parts[1]));
                String[] barCodeStr = parts[2].split(",");
                for (String bc : barCodeStr) {
                    productItems.add(new ProductItem(product, new BarCode(bc)));
                }
            } else {
                throw new CsvBadFormat(line);
            }
        } catch (Exception e) {
            throw new CsvBadFormat(line);
        }
        return productItems;
    }
}
