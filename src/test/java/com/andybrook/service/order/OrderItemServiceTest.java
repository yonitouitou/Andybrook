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
public class OrderItemServiceTest {

    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProductService productService;

    private Customer customer;
    private Order order;
    private Product product;
    private OrderItemInfo orderItemInfo;

    @Before
    public void init() throws Exception {
        customer = customerService.newCustomer(CustomerGenerator.generateCustomer());
        order = orderService.newOrder(createNewOrderRequest(customer));
        product = productService.addProduct(ProductGenerator.generateProduct());
        orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product);
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
    public void deleteOrderItemFromOrderDbTest() throws Exception {
        OrderItem<? extends Product> orderItem = addOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertTrue(orderItemService.get(orderItem.getId()) == null);
    }

    private OrderItem<? extends Product> addOrderItem() throws Exception {
        return orderService.addOrderItem(order.getId(), orderItemInfo);
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
