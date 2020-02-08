package com.andybrook.api.rest;

import com.andybrook.api.rest.ctx.DeleteOrderItemRestRequest;
import com.andybrook.api.rest.ctx.GenericRequestById;
import com.andybrook.api.rest.ctx.GenericRequestByIds;
import com.andybrook.api.rest.ctx.OrderItemAddByBarCodeRestRequest;
import com.andybrook.api.rest.ctx.OrderItemAddRequestByInfo;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.order.NewOrderRequest;
import com.andybrook.model.request.order.UpdateOrderRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequest;
import com.andybrook.model.request.orderitem.OrderItemAddRequestByBarCode;
import com.andybrook.model.request.orderitem.OrderItemDeleteRequest;
import com.andybrook.util.NumberUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/order")
public class OrderController extends AbstractController {

    private static Logger LOGGER = System.getLogger(OrderController.class.getSimpleName());

    @Autowired
    private IOrderManager orderManager;

    @PostMapping(path = "/add")
    public Order newOrder(@RequestBody NewOrderRequest request) {
        LOGGER.log(Level.INFO, "Add order request received : " + request.toString());
        return orderManager.newOrder(request);
    }

    @PostMapping(path = "/update")
    public void updateOrder(@RequestBody UpdateOrderRequest request) {
        LOGGER.log(Level.INFO, "Update order request received : " + request.toString());
        orderManager.updateOrder(request);
    }

    @PostMapping(path = "/close")
    public Order closeOrder(@RequestBody GenericRequestById request) {
        LOGGER.log(Level.INFO, "Close order request received : " + request.toString());
        return orderManager.closeOrder(request.getId());
    }

    @GetMapping(path = "/get/{id}")
    public AggregatedOrder get(@PathVariable Long id) {
        LOGGER.log(Level.INFO, "Get Order request received for id : " + id);
        return orderManager.aggregate(id);
    }

    @PostMapping(path = "/getByIds")
    public List<Order> getByIds(@RequestBody GenericRequestByIds request) {
        LOGGER.log(Level.INFO, "Get order request received for ids : " + request.getIds());
        return orderManager.getOrders(request.getIdsAsLong());
    }

    @GetMapping(path = "/searchByIdOrName/{input}")
    public List<AggregatedOrder> getByName(@PathVariable String input) {
        LOGGER.log(Level.INFO, "Get order request received for input : " + input);
        Long inputAsLong = NumberUtil.parseNumber(input, Long.class);
        List<AggregatedOrder> orders = Collections.emptyList();
        if (inputAsLong != null) {
            if (inputAsLong > 0) {
                orders = List.of(orderManager.aggregate(inputAsLong));
            }
        } else {
            List<Order> ordersFound = new ArrayList<>(orderManager.getOrdersByNameContaining(input.trim()));
            orders = aggregateOrders(ordersFound);
        }
        return orders;
    }

    @GetMapping(path = "/all")
    public List<AggregatedOrder> getAll() {
        LOGGER.log(Level.INFO, "Get all aggregated orders request received");
        return aggregateOrders(orderManager.getAll());
    }

    @PostMapping(path = "/addOrderItemByInfo")
    public List<OrderItem> addOrderItems(@RequestBody OrderItemAddRequestByInfo request) {
        LOGGER.log(Level.INFO, "Request received to updateProductItem order : " + request);
        return orderManager.addOrderItems(new OrderItemAddRequest(request.getOrderId(), request.getProductItemInfo()));
    }

    @PostMapping(path = "/addSingleOrderItemsByBarCode")
    public OrderItem addOrderItems(@RequestBody OrderItemAddByBarCodeRestRequest request) {
        LOGGER.log(Level.INFO, "Request received to updateProductItem order : " + request);
        return orderManager.addOrderItemByBarCode(new OrderItemAddRequestByBarCode(request.getOrderId(), request.getBarCode()));
    }

    @DeleteMapping(path = "/deleteOrderItem/{orderId}/{orderItemId}")
    public void deleteOrderItem(@PathVariable long orderId, @PathVariable long orderItemId) {
        LOGGER.log(Level.INFO, "Request received to remove order item " + orderItemId + " from order " + orderId);
        orderManager.deleteOrderItem(new OrderItemDeleteRequest(orderId, orderItemId));
    }

    @PostMapping(path = "/deleteOrderItems")
    public void deleteOrderItems(@RequestBody DeleteOrderItemRestRequest request) {
        LOGGER.log(Level.INFO, "Request received to remove order items : " + request.toString());
        for (int i = 0; i < request.getOrderItemsId().length; i++) {
            orderManager.deleteOrderItem(new OrderItemDeleteRequest(request.getOrderId(), request.getOrderItemsId()[i]));
        }
    }

    @GetMapping(path = "/ordersOfStore/{storeId}")
    public List<AggregatedOrder> getOrdersOfStore(@PathVariable long storeId) {
        LOGGER.log(Level.INFO, "Get orders of store " + storeId);
        List<Order> ordersOfCustomer = orderManager.getOrdersOfStore(storeId);
        return aggregateOrders(ordersOfCustomer);
    }

    private List<AggregatedOrder> aggregateOrders(Collection<Order> orders) {
        return orders.stream()
                .map(order -> orderManager.aggregate(order))
                .collect(Collectors.toList());
    }
}