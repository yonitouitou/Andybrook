package com.andybrook.init;

import com.andybrook.exception.*;
import com.andybrook.generator.OrderItemGenerator;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.StoreGenerator;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.manager.product.IProductManager;
import com.andybrook.model.BarCode;
import com.andybrook.model.customer.Store;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.stock.IStockService;
import com.andybrook.service.store.IStoreService;
import com.andybrook.util.clock.Clock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InitSystemTest {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int CUSTOMER_NUMBER_2 = 2;
    private static final int PRODUCT_NUMBER_70 = 10;
    private static final int PRODUCT_ITEM_FOR_EACH_PRODUCT_100 = 10;
    private static final int ORDER_NUMBER_10 = 10;
    private static final int MAX_ITEM_IN_ORDER_35 = 5;

    private List<Product> products;
    private Map<ProductId, List<Long>> productItemsIdMapByProductId;
    private List<Store> stores;

    @Autowired
    private IStoreService storeService;
    @Autowired
    private IOrderManager orderManager;
    @Autowired
    private IProductManager productManager;
    @Autowired
    private IStockService stockService;

    @Test
    //@Ignore
    public void initSystem() {
        products = createProducts();
        productItemsIdMapByProductId = createProductItems(products);
        stores = createStores();
        for (Store store : stores) {
            List<Long> orderIds = createOrders(store);
            for (Long id : orderIds) {
                int itemToAddNb = RANDOM.nextInt(0, MAX_ITEM_IN_ORDER_35);
                for (int i = 0; i < itemToAddNb; i++) {
                    Product product = products.get(RANDOM.nextInt(0, PRODUCT_NUMBER_70));
                    try {
                        addOrderItem(id, product.getId());
                    } catch (InsufficientQuantityException e){
                        System.err.println("Limit exceeded for product : " + product.getId());
                    } catch (Exception e) {
                        System.err.println("Item not added to order. Reason : " + e.getMessage());
                    }
                }
            }
        }
    }

    private Map<ProductId, List<Long>> createProductItems(List<Product> products) {
        productItemsIdMapByProductId = new HashMap<>(PRODUCT_NUMBER_70);
        for (Product product : products) {
            List<Long> productItemIds = new ArrayList<>(PRODUCT_ITEM_FOR_EACH_PRODUCT_100);
            for (int i = 0; i < PRODUCT_ITEM_FOR_EACH_PRODUCT_100; i++) {
                ProductItem productItem = new ProductItem(product, new BarCode(UUID.randomUUID().toString()));
                stockService.addProductItem(productItem);
                productItemIds.add(productItem.getId());
            }
            productItemsIdMapByProductId.put(product.getId(), productItemIds);
        }
        return productItemsIdMapByProductId;
    }

    private List<Product> createProducts() {
        List<Product> products = new ArrayList<>(PRODUCT_NUMBER_70);
        for (int i = 0; i < PRODUCT_NUMBER_70; i++) {
            Product product = ProductGenerator.generateProduct();
            productManager.addProduct(product);
            products.add(product);
        }
        return products;
    }

    private List<Store> createStores() {
        List<Store> stores = new LinkedList<>();
        for (int i = 0; i < CUSTOMER_NUMBER_2; i++) {
            Store store = StoreGenerator.generateStore();
            storeService.newStore(store);
            stores.add(store);
        }
        return stores;
    }

    private void addOrderItem(long orderId, ProductId productId)
            throws OrderNotFound, OrderClosed, ProductNotFound, InsufficientQuantityException, OrderItemNotFound, BarCodeNotFound {
        Long productItemId = productItemsIdMapByProductId.get(productId).get(RANDOM.nextInt(0, PRODUCT_ITEM_FOR_EACH_PRODUCT_100));
        ProductItem productItem = stockService.getProductItem(productItemId);
        OrderItem item = OrderItemGenerator.generateOrderItem(orderId, productItem);
        OrderItemInfo info = new OrderItemInfo(item.getId(), productItem.getProductId(), RANDOM.nextInt(1, 5));
        OrderItemAddRequest request = new OrderItemAddRequest(orderId, info);
        System.out.println("Add " + request.getQuantityRequested() + " order items of product " + productId + " into order " + orderId);
        orderManager.addOrderItems(request);
    }

    private List<Long> createOrders(Store store) throws StoreNotFound {
        List<Long> orderIds = new LinkedList<>();
        for (int i = 0; i < ORDER_NUMBER_10; i++) {
            long suffix = Clock.nanos();
            NewOrderRequest request = new NewOrderRequest();
            request.setName("Order_" + suffix);
            request.setStoreId(store.getId());
            request.setComment("Comment_" + suffix);
            Order order = orderManager.newOrder(request);
            orderIds.add(order.getId());
        }
        return orderIds;
    }

}
