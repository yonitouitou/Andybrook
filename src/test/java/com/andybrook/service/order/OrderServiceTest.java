package com.andybrook.service.order;

import com.andybrook.assertor.OrderItemAssertor;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.generator.CustomerGenerator;
import com.andybrook.generator.OrderItemGenerator;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.ProductItemGenerator;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.service.product.IProductService;
import com.andybrook.service.stock.IStockService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
    private IOrderItemService orderItemService;
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
        productItemInfo = OrderItemGenerator.generateOrderItemInfo(this.product, PRODUCT_QUANTITY -1);
    }

    @Test
    public void addOrderItemTest() {
        OrderItem orderItemAdded = addSingleOrderItem(productItemInfo).get(0);
        OrderItemAssertor.assertEquals(product, productItemInfo, orderItemAdded);
    }

    @Test(expected = InsufficientQuantityException.class)
    public void addOrderItemQuantityExceededTest() {
        productItemInfo = OrderItemGenerator.generateOrderItemInfo(this.product, PRODUCT_QUANTITY + 1);
        addSingleOrderItem(productItemInfo).get(0);
    }

    @Test
    public void deleteOrderItemFromOrderTest() {
        /*OrderItem orderItem = addSingleOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertTrue(order.getItem(orderItem.getId()) == null);*/
    }

    @Test
    public void deleteOrderItemFromOrderDbTest() {
        /*OrderItem orderItem = addSingleOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertFalse(orderItemService.isExist(orderItem.getId()));*/
    }

    private List<OrderItem> addSingleOrderItem(ProductItemInfo productItemInfo) {
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
