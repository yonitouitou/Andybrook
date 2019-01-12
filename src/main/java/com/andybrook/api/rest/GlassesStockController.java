package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.GenericRequestById;
import com.andybrook.manager.stock.IGlassesStockManager;
import com.andybrook.model.GlassesStockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.*;

import static com.andybrook.util.Const.CONSOLE_LOGGER_NAME;

@RestController
@RequestMapping("v1/gstock")
public class GlassesStockController extends AbstractController {

    private static Logger LOGGER = System.getLogger(CONSOLE_LOGGER_NAME);

    @Autowired
    private IGlassesStockManager glassesStockManager;

    @GetMapping(path = "/get/{id}")
    public GlassesTableRow getGlassesStockItem(@PathVariable long id) {
        GlassesTableRow glassesTableRow = null;
        LOGGER.log(Level.INFO, "Request received to get stock glasses : " + id);
        Optional<GlassesStockItem> glassesStockItemOpt = glassesStockManager.getGlassesStockItem(id);
        if (glassesStockItemOpt.isPresent()) {
            glassesTableRow = new GlassesTableRow(glassesStockItemOpt.get());
        }
        return glassesTableRow;
    }

    @GetMapping(path = "/getAll")
    public GlassesTableRow[] getAllGlassesStockItems() {
        LOGGER.log(Level.INFO, "Request received to get all stock glasses");
        Map<Long, GlassesStockItem> items = glassesStockManager.getAllGlassesStockItems();
        GlassesTableRow[] rows = new GlassesTableRow[items.size()];
        Collection<GlassesStockItem> values = items.values();
        int index = 0;
        for (GlassesStockItem item : values) {
            GlassesTableRow row = new GlassesTableRow(item);
            rows[index++] = row;
        }
        return rows;
    }

    @PostMapping(path = "/update")
    public GlassesTableRow updateGlassesStockItem(@RequestBody GlassesStockItem item) {
        LOGGER.log(Level.INFO, "Request received to update stock glasses : " + item);
        GlassesStockItem itemUpdated = glassesStockManager.updateGlassesStock(item);
        return new GlassesTableRow(itemUpdated);
    }

    @DeleteMapping(path = "/delete")
    public boolean deleteGlassesStockItem(@RequestBody GenericRequestById request) {
        LOGGER.log(Level.INFO, "Request received to remove stock glasses with Id : " + request.getId());
        return glassesStockManager.removeGlassesStock(request.getId());
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
