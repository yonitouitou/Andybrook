package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.GenericStockItemChangeRequest;
import com.andybrook.exception.*;
import com.andybrook.manager.order.IOrderItemManager;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("v1/stock")
public class OrderItemController extends AbstractController {

    private static Logger LOGGER = System.getLogger(OrderItemController.class.getSimpleName());

    @Autowired
    private IOrderItemManager stockItemManager;

    @GetMapping(path = "/get/{id}")
    public StockItemTableRow getGlassesStockItem(@PathVariable long id) throws OrderItemNotFound {
        LOGGER.log(Level.INFO, "Request received to get order glasses : " + id);
        OrderItem<? extends Product> glassesOrderItem = stockItemManager.getStockItem(id);
        return new StockItemTableRow(glassesOrderItem);
    }

    @GetMapping(path = "/getAll")
    public StockItemTableRow[] getStockItems() {
        LOGGER.log(Level.INFO, "Request received to get all order glasses");
        Map<Long, OrderItem<? extends Product>> items = stockItemManager.getOrderItems();
        StockItemTableRow[] rows = new StockItemTableRow[items.size()];
        Collection<OrderItem<? extends Product>> values = items.values();
        int index = 0;
        for (OrderItem<? extends Product> item : values) {
            StockItemTableRow row = new StockItemTableRow(item);
            rows[index++] = row;
        }
        return rows;
    }

    public class StockItemTableRow {
        private final OrderItem<? extends Product> item;
        private final double totalPrice;

        public StockItemTableRow(OrderItem<? extends Product> item) {
            this.item = item;
            this.totalPrice = item.calculateTotalPrice();
        }

        public OrderItem<? extends Product> getItem() {
            return item;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }
}
