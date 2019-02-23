package com.andybrook.api.rest;

import com.andybrook.exception.StockReportClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.manager.stock.IStockItemManager;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.StockItemUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("v1/stock")
public class StockItemController extends AbstractController {

    private static Logger LOGGER = System.getLogger(StockItemController.class.getSimpleName());

    @Autowired
    private IStockItemManager stockItemManager;

    @GetMapping(path = "/get/{id}")
    public GlassesTableRow getGlassesStockItem(@PathVariable long id) {
        GlassesTableRow glassesTableRow = null;
        LOGGER.log(Level.INFO, "Request received to get stock glasses : " + id);
        Optional<StockItem<? extends Product>> glassesStockItemOpt = stockItemManager.getStockItem(id);
        if (glassesStockItemOpt.isPresent()) {
            glassesTableRow = new GlassesTableRow(glassesStockItemOpt.get());
        }
        return glassesTableRow;
    }

    @GetMapping(path = "/getAll")
    public GlassesTableRow[] getStockItems() {
        LOGGER.log(Level.INFO, "Request received to get all stock glasses");
        Map<Long, StockItem<? extends Product>> items = stockItemManager.getAllStockItems();
        GlassesTableRow[] rows = new GlassesTableRow[items.size()];
        Collection<StockItem<? extends Product>> values = items.values();
        int index = 0;
        for (StockItem<? extends Product> item : values) {
            GlassesTableRow row = new GlassesTableRow(item);
            rows[index++] = row;
        }
        return rows;
    }

    @PostMapping(path = "/update")
    public GlassesTableRow updateStockItem(@RequestBody StockItemUpdateRequest request) throws OrderNotFound, StockReportClosed {
        LOGGER.log(Level.INFO, "Request received to update stock : " + request);
        StockItem<? extends Product> itemUpdated = stockItemManager.updateStockItem(request.getStockReportId(), request.getStockItem());
        return new GlassesTableRow(itemUpdated);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteStockItem(@PathVariable long id) {
        LOGGER.log(Level.INFO, "Request received to remove stock glasses with Id : " + id);
        return stockItemManager.removeStockItem(id);
    }


    public class GlassesTableRow {
        private final StockItem<? extends Product> item;
        private final double totalPrice;

        public GlassesTableRow(StockItem<? extends Product> item) {
            this.item = item;
            this.totalPrice = item.calculateTotalPrice();
        }

        public StockItem<? extends Product> getItem() {
            return item;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }
}
