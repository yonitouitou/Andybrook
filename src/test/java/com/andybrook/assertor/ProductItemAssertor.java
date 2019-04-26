package com.andybrook.assertor;

import com.andybrook.model.stock.ProductItem;
import org.junit.Assert;

public final class ProductItemAssertor {

    public static void assertEquals(ProductItem expected, ProductItem actual) {
        Assert.assertEquals("Id", expected.getId(), actual.getId());
        Assert.assertEquals("CreatedDatetime", expected.getCreatedDatetime(), actual.getCreatedDatetime());
        Assert.assertEquals("LastModifiedDatetime", expected.getLastModifiedDatetime(), actual.getLastModifiedDatetime());
        assertEqualsStaticField(expected, actual);
    }

    public static void assertEqualsStaticField(ProductItem expected, ProductItem actual) {
        ProductAssertor.assertEqualsStaticField(expected.getProduct(), actual.getProduct());
        BarCodeAssertor.assertEquals(expected.getBarCode(), actual.getBarCode());
    }
}
