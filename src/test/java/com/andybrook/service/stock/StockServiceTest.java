package com.andybrook.service.stock;

import com.andybrook.assertor.ProductItemAssertor;
import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.ProductItemGenerator;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.product.IProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StockServiceTest {

    private ProductItem productItem;

    @Autowired
    private IStockService stockService;
    @Autowired
    private IProductService productService;

    @Before
    public void init() {
        Product product = productService.addProduct(ProductGenerator.generateProduct());;
        productItem = ProductItemGenerator.generateSingleProductItem(product);
    }

    @Test
    public void addSingleProductItemTest() {
        stockService.addProductItem(productItem);
        ProductItem productItemSaved = stockService.getProductItem(productItem.getId());
        ProductItemAssertor.assertEqualsStaticField(productItem, productItemSaved);
        Assert.assertNotNull(productItemSaved.getId());
        Assert.assertNotNull(productItemSaved.getLastModifiedDatetime());
        Assert.assertNotNull(productItemSaved.getCreatedDatetime());
        Assert.assertFalse(productItemSaved.getOrderItemIdOpt().isPresent());
    }
}
