package com.andybrook.assertor;

import com.andybrook.model.product.Product;
import org.junit.Assert;

public final class ProductAssertor {

    public static void assertEquals(Product expected, Product actual) {
        Assert.assertEquals("Id", expected.getId(), actual.getId());
        assertEqualsStaticField(expected, actual);
    }

    public static void assertEqualsStaticField(Product expected, Product actual) {
        Assert.assertEquals("Name", expected.getName(), actual.getName());
        Assert.assertEquals("Price", expected.getPrice(), actual.getPrice(), 0d);
        Assert.assertEquals("Type", expected.getType(), actual.getType());
    }
}
