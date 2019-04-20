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
        return new Glasses(null, "G" + System.currentTimeMillis(), RANDOM.nextInt(10, 100));
    }
}
