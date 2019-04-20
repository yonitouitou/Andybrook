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
        Product product = ProductGenerator.generateProduct();
        this.product = productService.addProduct(product);
        List<ProductItem> productItems = ProductItemGenerator.generateProductItem(product, PRODUCT_QUANTITY);
        for (ProductItem item : productItems) {
            stockService.addProductItem(item);
        }
        productItemInfo = OrderItemGenerator.generateOrderItemInfo(this.product);
    }

    @Test
    public void addOrderItemTest() {
        OrderItem orderItemAdded = addSingleOrderItem().get(0);
        OrderItemAssertor.assertEquals(product, productItemInfo, orderItemAdded);
    }

    @Test
    public void deleteOrderItemFromOrderTest() {
        /*OrderItem orderItem = addSingleOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertTrue(order.getItem(orderItem.getId()) == null);*/
    }

    @Test
    @Ignore
    public void updateOrderItem() {
        /*int qtyAdded = 2;
        OrderItem orderItem = addSingleOrderItem();
        ProductItemInfo info = new ProductItemInfo(orderItem.getId(), orderItem.getProductItem().getId());
        OrderItem orderItemUpdated = orderService.addOrderItems(order.getId(), info);
        Assert.assertEquals("Product.QuantityCreated", PRODUCT_QUANTITY, orderItem.getProductItem().getQuantityCreated());
        Assert.assertEquals("Product.QuantityUsed", 1, orderItemUpdated.getProductItem().getQuantityUsed());*/
    }

    @Test
    public void deleteOrderItemFromOrderDbTest() {
        /*OrderItem orderItem = addSingleOrderItem();
        deleteOrderItem(orderItem.getId());
        Assert.assertFalse(orderItemService.isExist(orderItem.getId()));*/
    }

    @Test(expected = InsufficientQuantityException.class)
    public void addOrderItemQuantityExceededTest() {
        /*product = productService.addProduct(ProductGenerator.generateProduct(2));
        for (int i = 0; i < 3; i++) {
            productItemInfo = OrderItemGenerator.generateOrderItemInfo(product);
            addSingleOrderItem();
        }*/
    }

    @Test(expected = InsufficientQuantityException.class)
    @Ignore
    public void updateOrderItemQuantityExceededTest() {
        /*product = productService.addProduct(ProductGenerator.generateProduct(5));
        productItemInfo = OrderItemGenerator.generateOrderItemInfo(product);
        addSingleOrderItem();*/
        //orderService.addOrderItems(order.getId(), OrderItemGenerator.generateOrderItemInfo(product));
    }

    private List<OrderItem> addSingleOrderItem() {
        return orderService.addOrderItems(order.getId(), productItemInfo, 1);
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
