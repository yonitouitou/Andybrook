package com.andybrook.assertor;

import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.model.stock.ProductItem;
import org.junit.Assert;

public final class OrderItemAssertor {

    public static void assertEquals(OrderItem expected, OrderItem actual) {
        Assert.assertNotNull("Id", actual.getId());
        Assert.assertNotNull("CreationDatetime", actual.getCreatedDatetime());
        Assert.assertEquals("LastModifiedDatetime", expected.getLastModifiedDatetime(), actual.getLastModifiedDatetime());
        ProductItemAssertor.assertEquals(expected.getProductItem(), actual.getProductItem());
    }

    public static void assertEqualsStaticFields(OrderItem expected, OrderItem actual) {
        ProductItemAssertor.assertEquals(expected.getProductItem(), actual.getProductItem());
    }
}
