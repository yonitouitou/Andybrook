package com.andybrook.service.stock;

import com.andybrook.TestConfig;
import com.andybrook.model.Glasses;
import com.andybrook.model.GlassesStockItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class GlassesStockServiceTest {

    private static final String GLASSES_STOCK_ITEM = GlassesStockItem.class.getSimpleName() + ".";

    @Autowired
    private GlassesStockService glassesStockService;

    @Test
    public void newGlassesStockItemTest() {
        Glasses glasses = new Glasses("GlassesName", 10.2);
        GlassesStockItem item = new GlassesStockItem(glasses, 5);
        executeAndAssertNewGlassesStockItem(item);
    }

    private void executeAndAssertNewGlassesStockItem(GlassesStockItem originalItem) {
        GlassesStockItem updatedItem = glassesStockService.newGlassesStockItem(originalItem);
        Assert.assertNotNull(GLASSES_STOCK_ITEM + "Id", updatedItem.getId());
        Assert.assertEquals(GLASSES_STOCK_ITEM + "Glasses", originalItem.getGlasses(), updatedItem.getGlasses());
        Assert.assertEquals(GLASSES_STOCK_ITEM + "Quantity", originalItem.getQuantity(), updatedItem.getQuantity(), 0);
    }
}
