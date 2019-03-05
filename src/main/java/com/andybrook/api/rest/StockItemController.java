package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.GenericStockItemChangeRequest;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StockItemNotFound;
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

@RestController
@RequestMapping("v1/stock")
public class StockItemController extends AbstractController {

    private static Logger LOGGER = System.getLogger(StockItemController.class.getSimpleName());

    @Autowired
    private IStockItemManager stockItemManager;

    @GetMapping(path = "/get/{id}")
    public StockItemTableRow getGlassesStockItem(@PathVariable long id) throws StockItemNotFound {
        StockItemTableRow stockItemTableRow = null;
        LOGGER.log(Level.INFO, "Request received to get stock glasses : " + id);
        StockItem<? extends Product> glassesStockItem = stockItemManager.getStockItem(id);
        return new StockItemTableRow(glassesStockItem);
    }

    @GetMapping(path = "/getAll")
    public StockItemTableRow[] getStockItems() {
        LOGGER.log(Level.INFO, "Request received to get all stock glasses");
        Map<Long, StockItem<? extends Product>> items = stockItemManager.getAllStockItems();
        StockItemTableRow[] rows = new StockItemTableRow[items.size()];
        Collection<StockItem<? extends Product>> values = items.values();
        int index = 0;
        for (StockItem<? extends Product> item : values) {
            StockItemTableRow row = new StockItemTableRow(item);
            rows[index++] = row;
        }
        return rows;
    }

    @PostMapping(path = "/update")
    public StockItemTableRow updateStockItem(@RequestBody StockItemUpdateRequest request) throws OrderNotFound, OrderClosed {
        LOGGER.log(Level.INFO, "Request received to update stock : " + request);
        StockItem<? extends Product> itemUpdated = stockItemManager.updateStockItem(request.getStockReportId(), request.getStockItem());
        return new StockItemTableRow(itemUpdated);
    }

    @PostMapping(path = "/incrementQuantity")
    public StockItemTableRow incrementQuantity(@RequestBody GenericStockItemChangeRequest request) throws StockItemNotFound, OrderNotFound {
        LOGGER.log(Level.INFO, "Request received to increment stock item: " + request);
        StockItem<? extends Product> stockItem = stockItemManager.incrementQuantity(request.getOrderId(), request.getStockItemId());
        return new StockItemTableRow(stockItem);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteStockItem(@PathVariable long id) {
        LOGGER.log(Level.INFO, "Request received to remove stock glasses with Id : " + id);
        return stockItemManager.removeStockItem(id);
    }


    public class StockItemTableRow {
        private final StockItem<? extends Product> item;
        private final double totalPrice;

        public StockItemTableRow(StockItem<? extends Product> item) {
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
