package com.andybrook.api.rest;

import com.andybrook.manager.stock.IGlassesStockManager;
import com.andybrook.model.GlassesStockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import static com.andybrook.util.Const.CONSOLE_LOGGER_NAME;

@RestController
@RequestMapping("v1/stock")
public class StockController extends AbstractController {

    private static Logger LOGGER = System.getLogger(CONSOLE_LOGGER_NAME);

    @Autowired
    private IGlassesStockManager glassesStockManager;

    @PostMapping(path = "/glasses")
    public GlassesTableRow updateGlasses(@RequestBody GlassesStockItem item) {
        LOGGER.log(Level.INFO, "Request received to update stock glasses : " + item);
        GlassesStockItem itemUpdated = glassesStockManager.updateGlassesStock(item);
        return new GlassesTableRow(itemUpdated);
    }

    public class GlassesTableRow {
        private final GlassesStockItem item;
        private final double totalPrice;

        public GlassesTableRow(GlassesStockItem item) {
            this.item = item;
            this.totalPrice = item.calculateTotalPrice();
        }

        public GlassesStockItem getItem() {
            return item;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }
}
