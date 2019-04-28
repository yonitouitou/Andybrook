package com.andybrook.model.api.rest;

import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class AggregatedOrder {

    private final AggregatedOrderInfo aggregatedOrderInfo;
    private final List<AggregatedOrderItem> aggregatedOrderItems;

    private AggregatedOrder(AggregatedOrderInfo aggregatedOrderInfo, List<AggregatedOrderItem> aggregatedOrderItems) {
        this.aggregatedOrderInfo = aggregatedOrderInfo;
        this.aggregatedOrderItems = aggregatedOrderItems;
    }

    public static AggregatedOrder toAggregatedOrder(Order order) {
        Map<Long, List<OrderItem>> orderItemByProductId = order.getItems()
                .stream()
                .collect(Collectors.groupingBy(OrderItem::getProductId));
        List<AggregatedOrderItem> aggregatedOrderItems = new LinkedList<>();
        orderItemByProductId.forEach((k, v) ->
            aggregatedOrderItems.add(new AggregatedOrderItem(v))
        );
        AggregatedOrderInfo info = AggregatedOrderInfo.toAggregatedOrderInfo(order);
        return new AggregatedOrder(info, aggregatedOrderItems);
    }

    public AggregatedOrderInfo getAggregatedOrderInfo() {
        return aggregatedOrderInfo;
    }

    public List<AggregatedOrderItem> getAggregatedOrderItems() {
        return aggregatedOrderItems;
    }
}
