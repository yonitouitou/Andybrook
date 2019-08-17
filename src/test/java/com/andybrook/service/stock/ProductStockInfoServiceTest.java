package com.andybrook.service.stock;

import com.andybrook.generator.ProductGenerator;
import com.andybrook.generator.ProductItemGenerator;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;
import com.andybrook.service.product.IProductService;
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
public class ProductStockInfoServiceTest {

    private Product product;

    @Autowired
    private IProductService productService;
    @Autowired
    private IStockService stockService;
    @Autowired
    private IProductStockInfoService productStockInfoService;

    @Before
    public void init() {
        product = ProductGenerator.generateProduct();
        product = productService.addProduct(product);
    }

    @Test
    public void initialStockInfoOnNewProductTest() {
        ProductStockInfo stockInfo = get(product.getId());
        assertCreatedQuantity(0, stockInfo.getQuantityCreated());
        assertUsedQuantity(0, stockInfo.getQuantityUsed());
        assertFreeQuantity(0, stockInfo.getQuantityUnused());
    }

    @Test
    public void stockInfoAfterProductItemsCreatedTest() {
        int qty = 20;
        List<ProductItem> productItems = ProductItemGenerator.generateProductItem(product, qty);
        for (ProductItem item : productItems) {
            stockService.addProductItem(item, false);
        }
        ProductStockInfo stockInfo = get(product.getId());
        assertCreatedQuantity(qty, stockInfo.getQuantityCreated());
        assertUsedQuantity(0, stockInfo.getQuantityUsed());
        assertFreeQuantity(qty, stockInfo.getQuantityUnused());
    }

    private ProductStockInfo get(long productId) {
        return ((ProductStockInfoService) productStockInfoService).get(productId);
    }

    private static void assertCreatedQuantity(int expected, int actual) {
        Assert.assertEquals("CreatedQuantity", expected, actual);
    }

    private static void assertUsedQuantity(int expected, int actual) {
        Assert.assertEquals("UsedQuantity", expected, actual);
    }

    private static void assertFreeQuantity(int expected, int actual) {
        Assert.assertEquals("FreeQuantity", expected, actual);
    }
}
