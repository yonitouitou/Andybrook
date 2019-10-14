package com.andybrook.service.product;

import com.andybrook.assertor.ProductAssertor;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.model.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    private Product product;

    @Autowired
    private IProductService productService;

    @Before
    public void init() {
        product = ProductGenerator.generateProduct();
    }

    @Test
    public void addProductTest() {
        Product savedProduct = productService.addProduct(product);
        ProductAssertor.assertEqualsStaticField(product, savedProduct);
        Assert.assertNotNull("Id", savedProduct.getId());
    }
}