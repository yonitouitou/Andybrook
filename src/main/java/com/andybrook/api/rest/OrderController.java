package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.GenericRequestById;
import com.andybrook.api.rest.ctx.GenericRequestByIds;
import com.andybrook.exception.OrderClosed;
import com.andybrook.exception.OrderNotFound;
import com.andybrook.exception.StoreNotFound;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.model.StockReport;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.model.request.UpdateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/stockReport")
public class OrderController extends AbstractController {

    private static Logger LOGGER = System.getLogger(OrderController.class.getSimpleName());

    @Autowired
    private IOrderManager orderManager;

    @PostMapping(path = "/add")
    public StockReport newOrder(@RequestBody NewOrderRequest request) throws StoreNotFound {
        LOGGER.log(Level.INFO, "Add report request received : " + request.toString());
        return orderManager.newOrder(request);
    }

    @PostMapping(path = "/update")
    public void updateOrder(@RequestBody UpdateOrderRequest request) throws OrderNotFound, OrderClosed {
        LOGGER.log(Level.INFO, "Update report request received : " + request.toString());
        orderManager.updateStockReport(request);
    }

    @PostMapping(path = "/close")
    public StockReport closeOrder(@RequestBody GenericRequestById request) throws OrderNotFound, OrderClosed {
        LOGGER.log(Level.INFO, "Close report request received : " + request.toString());
        return orderManager.closeOrder(request.getId());
    }

    @GetMapping(path = "/get/{id}")
    public StockReport get(@PathVariable Long id) throws OrderNotFound {
        LOGGER.log(Level.INFO, "Get report request received for id : " + id);
        return orderManager.getOrder(id);
    }

    @PostMapping(path = "/getByIds")
    public List<StockReport> getByIds(@RequestBody GenericRequestByIds request) {
        LOGGER.log(Level.INFO, "Get report request received for ids : " + request.getIds());
        return orderManager.getOrders(request.getIdsAsLong());
    }

    @GetMapping(path = "/getByName/{name}")
    public List<StockReport> getByName(@PathVariable String name) {
        LOGGER.log(Level.INFO, "Get report request received for name : " + name);
        return orderManager.getOrdersByNameContaining(name.trim());
    }

    @GetMapping(path = "/all")
    public Set<StockReport> getAll() {
        LOGGER.log(Level.INFO, "Get all report request received");
        return orderManager.getAll();
    }

}