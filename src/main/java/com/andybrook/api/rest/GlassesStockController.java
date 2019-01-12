package com.andybrook.api.rest;

import com.andybrook.manager.stock.IGlassesStockManager;
import com.andybrook.model.GlassesStockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import static com.andybrook.util.Const.CONSOLE_LOGGER_NAME;

@RestController
@RequestMapping("v1/gstock")
public class GlassesStockController extends AbstractController {

    private static Logger LOGGER = System.getLogger(CONSOLE_LOGGER_NAME);

    @Autowired
    private IGlassesStockManager glassesStockManager;

    @PostMapping(path = "/update")
    public GlassesTableRow updateGlasses(@RequestBody GlassesStockItem item) {
        LOGGER.log(Level.INFO, "Request received to update stock glasses : " + item);
        GlassesStockItem itemUpdated = glassesStockManager.updateGlassesStock(item);
        return new GlassesTableRow(itemUpdated);
    }

    @DeleteMapping(path = "/delete")
    public boolean removeGlasses(@RequestBody long id) {
        LOGGER.log(Level.INFO, "Request received to remove stock glasses with Id : " + id);
        return glassesStockManager.removeGlassesStock(id);
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
