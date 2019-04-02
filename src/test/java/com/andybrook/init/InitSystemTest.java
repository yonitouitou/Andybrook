package com.andybrook.init;

import com.andybrook.exception.*;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.StockItemGenerator;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.manager.product.IProductManager;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.util.clock.Clock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InitSystemTest {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int CUSTOMER_NUMBER_10 = 10;
    private static final int PRODUCT_NUMBER_200 = 200;
    private static final int ORDER_NUMBER_10 = 10;
    private static final int MAX_ITEM_IN_ORDER_101 = 150;

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IOrderManager orderManager;
    @Autowired
    private IProductManager productManager;

    @Test
    public void initSystem() throws Exception {
        List<Product> products = createProducts();
        List<Customer> customers = createCustomers();
        for (Customer customer : customers) {
            List<Long> orderIds = createOrders(customer);
            for (Long id : orderIds) {
                int itemToAddNb = RANDOM.nextInt(0, MAX_ITEM_IN_ORDER_101);
                System.out.println("Add " + itemToAddNb + " items to order " + id);
                for (int i = 0; i < itemToAddNb; i++) {
                    addOrderItem(id, products.get(RANDOM.nextInt(0, PRODUCT_NUMBER_200 - 1)));
                }
            }
        }
    }

    private List<Product> createProducts() {
        List<Product> products = new ArrayList<>(PRODUCT_NUMBER_200);
        for (int i = 0; i < PRODUCT_NUMBER_200; i++) {
            Product product = ProductGenerator.generateProduct();
            product = productManager.addProduct(product);
            products.add(product);
        }
        return products;
    }

    private List<Customer> createCustomers() {
        List<Customer> customers = new LinkedList<>();
        for (int i = 0; i < CUSTOMER_NUMBER_10; i++) {
            Owner owner = new Owner("Steve_" + i, "Smith", "steve_" + i +".smith@optika.net");
            Store store = new Store("Optika_" + i, "optika@gmail.com", "13 Avenue Paul Valery - Paris", owner);
            Customer customer = new Customer(store);
            customers.add(customerService.newCustomer(customer));
        }
        return customers;
    }

    private void addOrderItem(long orderId, Product product) throws OrderNotFound, OrderClosed, ProductNotFound, BarCodeAlreadyExist {
        OrderItem<? extends Product> orderItem = StockItemGenerator.generateOrderItem(product);
        orderManager.addOrderItem(orderId, orderItem);
    }

    public List<Long> createOrders(Customer customer) throws StoreNotFound, InterruptedException {
        List<Long> orderIds = new LinkedList<>();
        for (int i = 0; i < ORDER_NUMBER_10; i++) {
            long suffix = Clock.nanos();
            NewOrderRequest request = new NewOrderRequest();
            request.setName("Order_" + suffix);
            request.setCustomerId(customer.getId());
            request.setComment("Comment_" + suffix);
            Order order = orderManager.newOrder(request);
            orderIds.add(order.getId());
        }
        return orderIds;
    }

}
