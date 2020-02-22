package com.andybrook.model.order;

import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.api.AggregatedOrderInfo;
import com.andybrook.model.api.AggregatedOrderItem;
import com.andybrook.model.customer.Store;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.product.IProductService;
import com.andybrook.service.stock.IStockService;
import com.andybrook.service.store.IStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OrderAggregator implements IOrderAggregator {

    @Autowired
    private IProductService productService;
    @Autowired
    private IStockService stockService;
    @Autowired
    private IStoreService storeService;

    @Override
    public AggregatedOrder aggregate(Order order) {
        Map<ProductId, List<OrderItem>> orderItemByProductId = groupByProduct(order.getOrderItems());

        List<AggregatedOrderItem> aggregatedOrderItems = new LinkedList<>();
        orderItemByProductId.forEach((k, v) -> {
            Product product = productService.get(k);
            double ttlPrice = calculateOrderItemsTotalPrice(v);
            aggregatedOrderItems.add(new AggregatedOrderItem(v, product, ttlPrice));
        });

        Store store = storeService.getById(order.getStoreId());

        AggregatedOrderInfo orderInfo = toAggregatedOrderInfo(order, store);
        return new AggregatedOrder(orderInfo, aggregatedOrderItems);
    }

    private Map<ProductId, List<OrderItem>> groupByProduct(Collection<OrderItem> orderItems) {
        Map<ProductId, List<OrderItem>> orderItemByProductId = new HashMap<>();
        for (OrderItem orderItem : orderItems) {
            ProductItem productItem = stockService.getProductItem(orderItem.getProductItemId());
            ProductId productId = productItem.getProductId();
            List<OrderItem> items = orderItemByProductId.computeIfAbsent(productId, v -> new LinkedList<>());
            items.add(orderItem);
        }
        return orderItemByProductId;
    }

    private AggregatedOrderInfo toAggregatedOrderInfo(Order order, Store store) {
        int orderItemsSize = order.getOrderItems().size();
        List<ProductItem> productItems = toProductItemList(order.getOrderItems());
        int productsSize = getDistinctProductsSize(productItems);
        double ttlPrice = calculateTotalPrice(productItems);
        return new AggregatedOrderInfo(order.getId(), order.getName(), order.getComment(),
                store, order.getStatus(), order.getCreatedDateTime(), order.getLastModifiedDateTime(),
                order.getCloseDateTime(), orderItemsSize, productsSize, ttlPrice);
    }

    private List<ProductItem> toProductItemList(Collection<OrderItem> orderItems) {
        return orderItems
                .stream()
                .map(p -> stockService.getProductItem(p.getProductItemId()))
                .collect(Collectors.toList());
    }

    private double calculateTotalPrice(List<ProductItem> productItems) {
        return productItems.stream()
                .mapToDouble(item -> stockService.getPrice(item))
                .sum();
    }

    private double calculateOrderItemsTotalPrice(List<OrderItem> orderItems) {
        List<ProductItem> productItems = orderItems.stream()
                .map(orderItem -> stockService.getProductItem(orderItem.getProductItemId()))
                .collect(Collectors.toList());
        return calculateTotalPrice(productItems);
    }

    private int getDistinctProductsSize(List<ProductItem> productItems) {
        return (int) productItems.stream()
                .map(item -> productService.get(item.getProductId()))
                .map(Product::getType)
                .distinct()
                .count();
    }
}
