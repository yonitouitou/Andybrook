package com.andybrook.service.stock;

import com.andybrook.assertor.ProductItemAssertor;
import com.andybrook.exception.ProductItemNotFound;
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
    Product product;

    @Autowired
    private IStockService stockService;
    @Autowired
    private IProductService productService;

    @Before
    public void init() {
        productService.add(ProductGenerator.generateProduct());;
        productItem = ProductItemGenerator.generateSingleProductItem(product);
    }

    @Test
    public void addSingleProductItemTest() {
        productItem = addAndAssertSingleProductItem(productItem);
        Assert.assertEquals(1, stockService.getProductItemSizeOfProduct(productItem.getProductId()));
    }

    @Test
    public void addMultipleProductItemSameProductTest() {
        int createdQuantity = 100;
        for (int i = 0; i < createdQuantity; i++) {
            ProductItem newProductItem = ProductItemGenerator.generateSingleProductItem(product);
            addAndAssertSingleProductItem(newProductItem);
        }
        Assert.assertEquals(createdQuantity, stockService.getProductItemSizeOfProduct(product.getId()));
        Assert.assertEquals(createdQuantity, stockService.getFreeQuantity(product.getId()));
    }


    @Test(expected = ProductItemNotFound.class)
    public void getProductItemExpectedNotFoundExceptionTest() {
        stockService.getProductItem(Long.MAX_VALUE);
    }

    private ProductItem addAndAssertSingleProductItem(ProductItem productItem) {
        stockService.addProductItem(productItem);
        ProductItem productItemSaved = stockService.getProductItem(productItem.getId());
        assertProductItem(productItem, productItemSaved);
        return productItemSaved;
    }

    private void assertProductItem(ProductItem expected, ProductItem actual) {
        ProductItemAssertor.assertEqualsStaticField(expected, actual);
        Assert.assertNotNull(actual.getId());
        Assert.assertNotNull(actual.getLastModifiedDatetime());
        Assert.assertNotNull(actual.getCreatedDatetime());
        Assert.assertNull(actual.getOrderItemId());

    }
}
