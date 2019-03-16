package com.andybrook.init;

import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.StockItemGenerator;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.manager.product.IProductManager;
import com.andybrook.manager.stock.IOrderItemManager;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
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
    private static final int PRODUCT_NUMBER_200 = 200;
    private static final int ORDER_NUMBER_12 = 12;
    private static final int MAX_ITEM_IN_ORDER_101 = 101;

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IOrderManager orderManager;
    @Autowired
    private IOrderItemManager orderItemManager;
    @Autowired
    private IProductManager productManager;

    @Test
    public void initSystem() throws Exception {
        Customer customer = createCustomer();
        List<Product> products = createProducts();
        List<Long> orderIds = createOrders(customer);
        for (Long id : orderIds) {
            int itemToAddNb = RANDOM.nextInt(0, MAX_ITEM_IN_ORDER_101);
            System.out.println("Add " + itemToAddNb + " items to order " + id);
            for (int i = 0; i < itemToAddNb; i++) {
                addStockItemToOrder(id, products.get(RANDOM.nextInt(0, PRODUCT_NUMBER_200 -1)));
            }
        }
    }

    private List<Product> createProducts() {
        List<Product> products = new ArrayList<>(PRODUCT_NUMBER_200);
        for (int i = 0; i < PRODUCT_NUMBER_200; i++) {
            Product product = ProductGenerator.generateProduct();
            products.add(product);
            productManager.addProduct(product);
        }
        return products;
    }

    private Customer createCustomer() {
        Owner owner = new Owner("Steve" + System.currentTimeMillis(), "Smith", "steve.smith@optika.net");
        Store store = new Store("Optika" + System.currentTimeMillis(), "optika@gmail.com", "13 Avenue Paul Valery - Paris", owner);
        Customer customer = new Customer(store);
        return customerService.newCustomer(customer);
    }

    private void addStockItemToOrder(long orderId, Product product) throws OrderNotFound, OrderClosed {
        StockItem<? extends Product> stockItem = StockItemGenerator.generateStockItem(product);
        orderItemManager.updateStockItem(orderId, stockItem);
    }

    public List<Long> createOrders(Customer customer) throws StoreNotFound, InterruptedException {
        List<Long> orderIds = new LinkedList<>();
        for (int i = 0; i < ORDER_NUMBER_12; i++) {
            long suffix = Clock.millis();
            NewOrderRequest request = new NewOrderRequest();
            request.setName("StockReport_" + suffix);
            request.setCustomerId(customer.getId());
            request.setComment("Comment_" + suffix);
            StockReport order = orderManager.newOrder(request);
            orderIds.add(order.getId());
            Thread.sleep(2000);
        }
        return orderIds;
    }

}
