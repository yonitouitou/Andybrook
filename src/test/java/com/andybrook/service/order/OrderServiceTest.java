package com.andybrook.service.order;

import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.OrderClosed;
import com.andybrook.generator.OrderItemGenerator;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.ProductItemGenerator;
import com.andybrook.generator.StoreGenerator;
import com.andybrook.model.customer.Store;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.product.IProductService;
import com.andybrook.service.stock.IStockService;
import com.andybrook.service.store.IStoreService;

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
    private Store store;
    private Order order;
    private Product product;
    private OrderItemInfo orderItemInfo;

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IStoreService storeService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IStockService stockService;

    @Before
    public void init() {
        store = StoreGenerator.generateStore();
        storeService.newStore(store);
        order = orderService.newOrder(createNewOrderRequest(store));
        product = ProductGenerator.generateProduct();
        productService.add(product);
        List<ProductItem> productItems = ProductItemGenerator.generateProductItem(product, PRODUCT_QUANTITY);
        for (ProductItem item : productItems) {
            stockService.addProductItem(item);
        }
        orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product, PRODUCT_QUANTITY -1);
    }

    @Test
    public void addSingleOrderItemSingleQuantityTest() {
        orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product, 1);
        OrderItem orderItemAdded = addOrderItems(orderItemInfo).get(0);
        Order updatedOrder = orderService.getOrder(order.getId());
        Assert.assertTrue("Order.HasItem", updatedOrder.hasItem(orderItemAdded.getId()));
    }

    @Test
    public void addSingleOrderItemMultipleQuantityTest() {
        orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product, 2);
        List<OrderItem> orderItems = addOrderItems(orderItemInfo);
        Order updatedOrder = orderService.getOrder(order.getId());
        for (OrderItem orderItem : orderItems) {
            Assert.assertTrue("Order.HasItem", updatedOrder.hasItem(orderItem.getId()));
        }
    }

    @Test(expected = InsufficientQuantityException.class)
    public void addOrderItemQuantityExceededTest() {
        orderItemInfo = OrderItemGenerator.generateOrderItemInfo(product, PRODUCT_QUANTITY + 1);
        addOrderItems(orderItemInfo);
    }

    @Test(expected = OrderClosed.class)
    public void addOrderItemIntoClosedOrder() {
        orderService.closeOrder(this.order.getId());
        addOrderItems(orderItemInfo);
    }

    @Test
    public void deleteOrderItemTest() {
        OrderItem orderItem = addOrderItems(orderItemInfo).get(0);
        deleteOrderItem(orderItem.getId());
        Assert.assertFalse(order.hasItem(orderItem.getId()));

        order = orderService.getOrder(this.order.getId());
        Assert.assertFalse(order.hasItem(orderItem.getId()));
    }

    @Test
    public void getOrdersOfCustomerTest() {
        int nbOfOrderForCustomer = 3;
        Store store = StoreGenerator.generateStore();
        storeService.newStore(store);
        for (int i = 0; i < nbOfOrderForCustomer; i++) {
            orderService.newOrder(createNewOrderRequest(store));
        }
        Store store2 = StoreGenerator.generateStore();
        storeService.newStore(store2);
        orderService.newOrder(createNewOrderRequest(store2));

        List<Order> ordersOfCustomer = orderService.getOrdersOfStore(store.getId());
        Assert.assertEquals("OrderOfCustomerSize", nbOfOrderForCustomer, ordersOfCustomer.size());
    }

    private List<OrderItem> addOrderItems(OrderItemInfo orderItemInfo) {
        return orderService.addOrderItems(order.getId(), orderItemInfo, orderItemInfo.getRequestedQuantity());
    }

    private void deleteOrderItem(String orderItemId) {
        orderService.deleteOrderItem(this.order.getId(), orderItemId);
    }

    private NewOrderRequest createNewOrderRequest(Store store) {
        NewOrderRequest request = new NewOrderRequest();
        request.setName("OrderName_" + System.currentTimeMillis());
        request.setStoreId(store.getId());
        request.setComment("Comment_" + System.currentTimeMillis());
        return request;
    }
}
