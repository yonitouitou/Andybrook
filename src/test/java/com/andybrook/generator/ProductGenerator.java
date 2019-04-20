package com.andybrook.generator;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.andybrook.util.IdGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class ProductGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static final Product generateProduct() {
        /*Glasses glasses = new Glasses(null, "G" + System.currentTimeMillis(), RANDOM.nextInt(10, 100));
        int barCodeSize = RANDOM.nextInt(1, 10);
        for (int i = 0; i < barCodeSize; i++) {
            BarCode barCode = generateBarCode();
            glasses.addBarCode(barCode);
        }
        return glasses;*/
        return null;
    }

    public static final Product generateProduct(int quantity) {
        /*Glasses glasses = new Glasses(null, "G" + System.currentTimeMillis(), RANDOM.nextInt(10, 100));
        for (int i = 0; i < quantity; i++) {
            BarCode barCode = generateBarCode();
            glasses.addBarCode(barCode);
        }
        return glasses;*/
        return null;
    }

    public static BarCode generateBarCode() {
        return new BarCode(IdGenerator.generateAlfaNumericId());
    }
}
