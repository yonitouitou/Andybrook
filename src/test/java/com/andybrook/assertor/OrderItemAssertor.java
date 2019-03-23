package com.andybrook.assertor;

import com.andybrook.model.OrderItem;
import org.junit.Assert;

public final class OrderItemAssertor {

    public static void assertEquals(OrderItem expected, OrderItem actual) {
        Assert.assertNotNull("Id", actual.getId());
        Assert.assertNotNull("CreationDatetime", actual.getCreatedDatetime());
        Assert.assertEquals("Quantity", expected.getQuantity(), actual.getQuantity());
        Assert.assertEquals("ProductType", expected.getType(), actual.getType());
        Assert.assertEquals("BarCode", expected.getBarCode(), actual.getBarCode());
        ProductAssertor.assertEquals(expected.getProduct(), actual.getProduct());
    }
}
