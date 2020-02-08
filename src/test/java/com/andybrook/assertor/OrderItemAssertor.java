package com.andybrook.assertor;

import com.andybrook.model.order.OrderItem;

import org.junit.Assert;

public final class OrderItemAssertor {

    public static void assertEquals(OrderItem expected, OrderItem actual) {
        Assert.assertNotNull("Id", actual.getId());
        Assert.assertNotNull("CreationDatetime", actual.getCreatedDatetime());
        Assert.assertEquals("LastModifiedDatetime", expected.getLastModifiedDatetime(), actual.getLastModifiedDatetime());
        Assert.assertEquals("ProductItemId", expected.getProductItemId(), actual.getProductItemId());
    }
}
