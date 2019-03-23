package com.andybrook.api.rest;

import com.andybrook.api.rest.OrderItemController.StockItemTableRow;
import com.andybrook.api.rest.ctx.GenericRequestById;
import com.andybrook.api.rest.ctx.GenericRequestByIds;
import com.andybrook.exception.*;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.model.Order;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.NewOrderRequest;
import com.andybrook.model.request.OrderItemUpdateRequest;
import com.andybrook.model.request.UpdateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/order")
public class OrderController extends AbstractController {

    private static Logger LOGGER = System.getLogger(OrderController.class.getSimpleName());

    @Autowired
    private IOrderManager orderManager;

    @PostMapping(path = "/add")
    public Order newOrder(@RequestBody NewOrderRequest request) throws StoreNotFound {
        LOGGER.log(Level.INFO, "Add report request received : " + request.toString());
        return orderManager.newOrder(request);
    }

    @PostMapping(path = "/update")
    public void updateOrder(@RequestBody UpdateOrderRequest request) throws OrderNotFound, OrderClosed {
        LOGGER.log(Level.INFO, "Update report request received : " + request.toString());
        orderManager.updateOrder(request);
    }

    @PostMapping(path = "/close")
    public Order closeOrder(@RequestBody GenericRequestById request) throws OrderNotFound, OrderClosed {
        LOGGER.log(Level.INFO, "Close report request received : " + request.toString());
        return orderManager.closeOrder(request.getId());
    }

    @GetMapping(path = "/get/{id}")
    public Order get(@PathVariable Long id) throws OrderNotFound {
        LOGGER.log(Level.INFO, "Get report request received for id : " + id);
        return orderManager.getOrder(id);
    }

    @PostMapping(path = "/getByIds")
    public List<Order> getByIds(@RequestBody GenericRequestByIds request) {
        LOGGER.log(Level.INFO, "Get report request received for ids : " + request.getIds());
        return orderManager.getOrders(request.getIdsAsLong());
    }

    @GetMapping(path = "/getByName/{name}")
    public List<Order> getByName(@PathVariable String name) {
        LOGGER.log(Level.INFO, "Get report request received for name : " + name);
        return orderManager.getOrdersByNameContaining(name.trim());
    }

    @GetMapping(path = "/all")
    public Set<Order> getAll() {
        LOGGER.log(Level.INFO, "Get all report request received");
        return orderManager.getAll();
    }

    @PostMapping(path = "/updateOrderItem")
    public Order updateOrderItem(@RequestBody OrderItemUpdateRequest request)
            throws OrderNotFound, OrderClosed, ProductNotFound, BarCodeAlreadyExist {
        LOGGER.log(Level.INFO, "Request received to update order : " + request);
        return orderManager.addOrderItem(request.getOrderId(), request.getOrderItem());
    }

    @DeleteMapping(path = "/deleteOrderItem/{orderId}/{orderItemId}")
    public void deleteOrderItem(@PathVariable long orderId, @PathVariable long orderItemId) throws OrderNotFound, OrderClosed {
        LOGGER.log(Level.INFO, "Request received to remove order item " + orderItemId + " from order " + orderId);
        orderManager.deleteOrderItem(orderId, orderItemId);
    }

}