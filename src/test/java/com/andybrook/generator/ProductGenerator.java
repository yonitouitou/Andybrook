package com.andybrook.generator;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.andybrook.util.IdGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class ProductGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static final Product generateProduct() {
        int barCodeSize = RANDOM.nextInt(1, 10);
        Set<BarCode> barCodes = new HashSet<>(barCodeSize);
        for (int i = 0; i < barCodeSize; i++) {
            barCodes.add(generateBarCode());
        }
        Glasses glasses = new Glasses(null, "G" + System.currentTimeMillis(), RANDOM.nextInt(10, 100));
        glasses.setBarCodes(barCodes);
        return glasses;
    }

    public static BarCode generateBarCode() {
        return new BarCode(IdGenerator.generateAlfaNumericId());
    }
}
