package com.andybrook.assertor;

import com.andybrook.model.stock.ProductItem;
import org.junit.Assert;

public final class ProductItemAssertor {

    public static void assertEquals(ProductItem expected, ProductItem actual) {
        Assert.assertEquals("Id", expected.getId(), actual.getId());
        Assert.assertEquals("CreatedDatetime", expected.getCreatedDatetime(), actual.getCreatedDatetime());
        Assert.assertEquals("LastModifiedDatetime", expected.getLastModifiedDatetime(), actual.getLastModifiedDatetime());
        Assert.assertEquals("ProductId", expected.getProductId(), actual.getProductId());
        assertEqualsStaticField(expected, actual);
    }

    public static void assertEqualsStaticField(ProductItem expected, ProductItem actual) {
        BarCodeAssertor.assertEquals(expected.getBarCode(), actual.getBarCode());
    }
}
