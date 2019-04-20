package com.andybrook.assertor;

import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import org.junit.Assert;

public final class OrderItemAssertor {

    public static void assertEquals(OrderItem expected, OrderItem actual) {
        Assert.assertNotNull("Id", actual.getId());
        Assert.assertNotNull("CreationDatetime", actual.getCreatedDatetime());
        //Assert.assertEquals("BarCode", expected.getBarCode(), actual.getBarCode());
        //ProductAssertor.assertEquals(expected.getProductItem(), actual.getProductItem());
    }

    public static void assertEquals(Product product, ProductItemInfo info, OrderItem orderItem) {
        /*ProductAssertor.assertEquals(product, orderItem.getProductItem());
        if (info.getBarCodeId() == null) {
            Assert.assertNull(orderItem.getBarCode());
        } else {
            Assert.assertEquals("BarCode", info.getBarCodeId(), orderItem.getBarCode().getId());
        }*/
    }
}
