package com.andybrook.service.product;

import com.andybrook.exception.BarCodeNotFound;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.model.BarCode;
import com.andybrook.model.order.Order;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.service.customer.ICustomerService;
import com.andybrook.service.order.IOrderItemService;
import com.andybrook.service.order.IOrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

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

    @Before
    public void init() {
        //product = productService.addProduct(ProductGenerator.generateProduct(PRODUCT_QUANTITY));
    }

    @Test
    public void getByBarCodeTest() {
        /*for (BarCode barCode : product.getBarCodes().values()) {
            productService.getByBarCode(barCode.getId());
        }*/
    }

    @Test(expected = BarCodeNotFound.class)
    public void getByBarCodeNotFoundScenarioTest() {
        productService.getByBarCode("fakeBarCOde");
    }
}