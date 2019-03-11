package com.andybrook.generator;

import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.andybrook.util.IdGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class StockItemGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static StockItem<? extends Product> generateStockItem(Product product) {
        return new StockItem<>(null, product, ProductType.GLASSES, RANDOM.nextInt(1, 100));
    }
}
