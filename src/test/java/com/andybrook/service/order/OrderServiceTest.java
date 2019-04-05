package com.andybrook.service.order;

import com.andybrook.assertor.OrderItemAssertor;
import com.andybrook.generator.CustomerGenerator;
import com.andybrook.generator.OrderItemGenerator;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.service.product.IProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {

    private static final int PRODUCT_QUANTITY = 20;
    private static final int ORDER_ITEM_QUANTITY = 5;
    private Customer customer;
    private Order order;
    private Product product;
    private OrderItemInfo orderItemInfo;

    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProductService productService;

    @Before
    public void init() throws Exception {
        customer = customerService.newCustomer(CustomerGenerator.generateCustomer());
        order = orderService.newOrder(createNewOrderRequest(customer));
        product = productService.addProduct(ProductGenerator.generateProduct(PRODUCT_QUANTITY));
        orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product, ORDER_ITEM_QUANTITY);
    }

    @Test
    public void addOrderItemTest() throws Exception {
        OrderItem<? extends Product> orderItemAdded = addOrderItem();
        OrderItemAssertor.assertEquals(product, orderItemInfo, orderItemAdded);
    }

    @Test
    public void deleteOrderItemFromOrderTest() throws Exception {
        OrderItem<? extends Product> orderItem = addOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertTrue(order.getItem(orderItem.getId()) == null);
    }

    @Test
    public void updateOrderItem() throws Exception {
        int qtyAdded = 2;
        OrderItem<? extends Product> orderItem = addOrderItem();
        OrderItemInfo info = new OrderItemInfo(orderItem.getId(), orderItem.getProduct().getId(), qtyAdded);
        OrderItem<? extends Product> orderItemUpdated = orderService.addOrUpdateOrderItem(order.getId(), info);
        Assert.assertEquals("OrderItem.Quantity", orderItem.getQuantity() + qtyAdded, orderItemUpdated.getQuantity());
        Assert.assertEquals("Product.QuantityCreated", PRODUCT_QUANTITY, orderItem.getProduct().getQuantityCreated());
        Assert.assertEquals("Product.QuantityUsed", orderItemUpdated.getQuantity(), orderItemUpdated.getProduct().getQuantityUsed());
    }

    @Test
    public void deleteOrderItemFromOrderDbTest() throws Exception {
        OrderItem<? extends Product> orderItem = addOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertFalse(orderItemService.isExist(orderItem.getId()));
    }

    private OrderItem<? extends Product> addOrderItem() throws Exception {
        return orderService.addOrUpdateOrderItem(order.getId(), orderItemInfo);
    }

    private void deleteOrderItem(long orderItemId) throws Exception {
        orderService.deleteOrderItem(this.order.getId(), orderItemId);
    }

    private NewOrderRequest createNewOrderRequest(Customer customer) {
        NewOrderRequest request = new NewOrderRequest();
        request.setName("OrderName_" + System.currentTimeMillis());
        request.setCustomerId(customer.getId());
        request.setComment("Comment_" + System.currentTimeMillis());
        return request;
    }
}
