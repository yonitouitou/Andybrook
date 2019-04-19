package com.andybrook.service.order;

import com.andybrook.assertor.OrderItemAssertor;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.generator.CustomerGenerator;
import com.andybrook.generator.OrderItemGenerator;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.service.product.IProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
    public void init() {
        customer = customerService.newCustomer(CustomerGenerator.generateCustomer());
        order = orderService.newOrder(createNewOrderRequest(customer));
        product = productService.addProduct(ProductGenerator.generateProduct(PRODUCT_QUANTITY));
        orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product);
    }

    @Test
    public void addOrderItemTest() {
        OrderItem orderItemAdded = addOrderItem();
        OrderItemAssertor.assertEquals(product, orderItemInfo, orderItemAdded);
    }

    @Test
    public void deleteOrderItemFromOrderTest() {
        OrderItem orderItem = addOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertTrue(order.getItem(orderItem.getId()) == null);
    }

    @Test
    @Ignore
    public void updateOrderItem() {
        int qtyAdded = 2;
        OrderItem orderItem = addOrderItem();
        OrderItemInfo info = new OrderItemInfo(orderItem.getId(), orderItem.getProduct().getId());
        OrderItem orderItemUpdated = orderService.addOrUpdateOrderItem(order.getId(), info);
        Assert.assertEquals("Product.QuantityCreated", PRODUCT_QUANTITY, orderItem.getProduct().getQuantityCreated());
        Assert.assertEquals("Product.QuantityUsed", 1, orderItemUpdated.getProduct().getQuantityUsed());
    }

    @Test
    public void deleteOrderItemFromOrderDbTest() {
        OrderItem orderItem = addOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertFalse(orderItemService.isExist(orderItem.getId()));
    }

    @Test(expected = InsufficientQuantityException.class)
    public void addOrderItemQuantityExceededTest() {
        product = productService.addProduct(ProductGenerator.generateProduct(2));
        for (int i = 0; i < 3; i++) {
            orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product);
            addOrderItem();
        }
    }

    @Test(expected = InsufficientQuantityException.class)
    @Ignore
    public void updateOrderItemQuantityExceededTest() {
        product = productService.addProduct(ProductGenerator.generateProduct(5));
        orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product);
        addOrderItem();
        orderService.addOrUpdateOrderItem(order.getId(), OrderItemGenerator.generateOrderItemInfo(product));
    }

    private OrderItem addOrderItem() {
        return orderService.addOrUpdateOrderItem(order.getId(), orderItemInfo);
    }

    private void deleteOrderItem(long orderItemId) {
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
