package com.andybrook.generator;

import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;

import java.util.concurrent.ThreadLocalRandom;

public final class ProductGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static final Product generateProduct() {
        return new Glasses("G" + System.currentTimeMillis(), RANDOM.nextInt(10, 100));
    }
}
