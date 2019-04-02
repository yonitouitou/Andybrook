package com.andybrook.service.order;

import com.andybrook.assertor.OrderItemAssertor;
import com.andybrook.generator.CustomerGenerator;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.StockItemGenerator;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.service.product.IProductService;
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

    @Test
    public void addOrderItemTest() throws Exception {
        Customer customer = CustomerGenerator.generateCustomer();
        customer = customerService.newCustomer(customer);
        Order order = orderService.newOrder(createNewOrderRequest(customer));
        Product product = ProductGenerator.generateProduct();
        product = productService.addProduct(product);
        OrderItem<? extends Product> orderItem = StockItemGenerator.generateOrderItem(product);
        order = orderService.addOrderItem(order.getId(), orderItem);
        OrderItemAssertor.assertEquals(orderItem, order.findLastItemAdded());
    }

    private NewOrderRequest createNewOrderRequest(Customer customer) {
        NewOrderRequest request = new NewOrderRequest();
        request.setName("OrderName_" + System.currentTimeMillis());
        request.setCustomerId(customer.getId());
        request.setComment("Comment_" + System.currentTimeMillis());
        return request;
    }
}
