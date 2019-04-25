package com.andybrook.assertor;

import com.andybrook.model.stock.ProductItem;

public final class ProductItemAssertor {

    public static void assertEqualsStaticField(ProductItem expected, ProductItem actual) {
        ProductAssertor.assertEqualsStaticField(expected.getProduct(), actual.getProduct());
        BarCodeAssertor.assertEquals(expected.getBarCode(), actual.getBarCode());
    }
}
