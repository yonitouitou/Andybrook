package com.andybrook.manager;

import com.andybrook.generator.ProductGenerator;
import com.andybrook.manager.product.IProductManager;
import com.andybrook.model.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductManagerTest {

    @Autowired
    private IProductManager productManager;

    @Test
    public void addProductTest() {
        Product product = ProductGenerator.generateProduct();
        productManager.addProduct(product);
    }
}
