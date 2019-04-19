package com.andybrook.assertor;

import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import org.junit.Assert;

public final class OrderItemAssertor {

    public static void assertEquals(OrderItem expected, OrderItem actual) {
        Assert.assertNotNull("Id", actual.getId());
        Assert.assertNotNull("CreationDatetime", actual.getCreatedDatetime());
        Assert.assertEquals("BarCode", expected.getBarCode(), actual.getBarCode());
        ProductAssertor.assertEquals(expected.getProduct(), actual.getProduct());
    }

    public static void assertEquals(Product product, OrderItemInfo info, OrderItem orderItem) {
        ProductAssertor.assertEquals(product, orderItem.getProduct());
        if (info.getBarCodeId() == null) {
            Assert.assertNull(orderItem.getBarCode());
        } else {
            Assert.assertEquals("BarCode", info.getBarCodeId(), orderItem.getBarCode().getId());
        }
    }
}
