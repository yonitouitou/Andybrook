package com.andybrook.generator;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;

import java.util.LinkedList;
import java.util.List;

public final class ProductItemGenerator {

    public static ProductItem generateSingleProductItem(Product product) {
        return generateProductItem(product, 1).get(0);
    }

    public static List<ProductItem> generateProductItem(Product product, int requestedQty) {
        List<ProductItem> items = new LinkedList<>();
        for (int i = 0; i < requestedQty; i++) {
            BarCode barCode = BarCodeGenerator.generateBarCode();
            items.add(new ProductItem(product, barCode));
        }
        return items;
    }
}
