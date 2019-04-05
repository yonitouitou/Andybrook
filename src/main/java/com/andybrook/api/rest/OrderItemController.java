package com.andybrook.api.rest;

import com.andybrook.exception.*;
import com.andybrook.manager.order.IOrderItemManager;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

@RestController
@RequestMapping("v1/stock")
public class OrderItemController extends AbstractController {

    private static Logger LOGGER = System.getLogger(OrderItemController.class.getSimpleName());

    @Autowired
    private IOrderItemManager stockItemManager;

    @GetMapping(path = "/get/{id}")
    public StockItemTableRow getGlassesStockItem(@PathVariable long id) throws OrderItemNotFound {
        LOGGER.log(Level.INFO, "Request received to get order glasses : " + id);
        OrderItem<? extends Product> glassesOrderItem = stockItemManager.getOrderItem(id);
        return new StockItemTableRow(glassesOrderItem);
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
