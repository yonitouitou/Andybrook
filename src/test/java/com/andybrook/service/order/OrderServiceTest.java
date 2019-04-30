package com.andybrook.service.order;

import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.OrderClosed;
import com.andybrook.generator.CustomerGenerator;
import com.andybrook.generator.OrderItemGenerator;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.ProductItemGenerator;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.service.product.IProductService;
import com.andybrook.service.stock.IStockService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {

    private static final int PRODUCT_QUANTITY = 20;
    private static final int ORDER_ITEM_QUANTITY = 5;
    private Customer customer;
    private Order order;
    private Product product;
    private ProductItemInfo productItemInfo;

    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IStockService stockService;

    @Before
    public void init() {
        customer = customerService.newCustomer(CustomerGenerator.generateCustomer());
        order = orderService.newOrder(createNewOrderRequest(customer));
        product = ProductGenerator.generateProduct();
        product = productService.addProduct(product);
        List<ProductItem> productItems = ProductItemGenerator.generateProductItem(product, PRODUCT_QUANTITY);
        for (ProductItem item : productItems) {
            item = stockService.addProductItem(item);
        }
        productItemInfo = OrderItemGenerator.generateOrderItemInfo(product, PRODUCT_QUANTITY -1);
    }

    @Test
    public void addSingleOrderItemSingleQuantityTest() {
        productItemInfo = OrderItemGenerator.generateOrderItemInfo(product, 1);
        OrderItem orderItemAdded = addOrderItems(productItemInfo).get(0);
        Order updatedOrder = orderService.getOrder(order.getId());
        Assert.assertTrue("Order.HasItem", updatedOrder.hasItem(orderItemAdded.getId()));
        Assert.assertEquals("ProductId", product.getId(), updatedOrder.getItem(orderItemAdded.getId()).getProductId(), 0);
    }

    @Test
    public void addSingleOrderItemMultipleQuantityTest() {
        productItemInfo = OrderItemGenerator.generateOrderItemInfo(product, 2);
        List<OrderItem> orderItems = addOrderItems(productItemInfo);
        Order updatedOrder = orderService.getOrder(order.getId());
        for (OrderItem orderItem : orderItems) {
            Assert.assertTrue("Order.HasItem", updatedOrder.hasItem(orderItem.getId()));
            Assert.assertEquals("ProductId", product.getId(), updatedOrder.getItem(orderItem.getId()).getProductId(), 0);
        }
    }

    @Test(expected = InsufficientQuantityException.class)
    public void addOrderItemQuantityExceededTest() {
        productItemInfo = OrderItemGenerator.generateOrderItemInfo(product, PRODUCT_QUANTITY + 1);
        addOrderItems(productItemInfo).get(0);
    }

    @Test(expected = OrderClosed.class)
    public void addOrderItemIntoClosedOrder() {
        orderService.closeOrder(this.order.getId());
        addOrderItems(productItemInfo).get(0);
    }

    @Test
    public void deleteOrderItemTest() {
        OrderItem orderItem = addOrderItems(productItemInfo).get(0);
        deleteOrderItem(orderItem.getId());
        Assert.assertFalse(order.hasItem(orderItem.getId()));

        order = orderService.getOrder(this.order.getId());
        Assert.assertFalse(order.hasItem(orderItem.getId()));
    }

    private List<OrderItem> addOrderItems(ProductItemInfo productItemInfo) {
        return orderService.addOrderItems(order.getId(), productItemInfo, productItemInfo.getRequestedQuantity());
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