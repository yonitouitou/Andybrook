package com.andybrook.model.api;

import java.util.List;

public final class AggregatedOrder {

    private final AggregatedOrderInfo aggregatedOrderInfo;
    private final List<AggregatedOrderItem> aggregatedOrderItems;

    public AggregatedOrder(AggregatedOrderInfo aggregatedOrderInfo, List<AggregatedOrderItem> aggregatedOrderItems) {

        this.aggregatedOrderInfo = aggregatedOrderInfo;
        this.aggregatedOrderItems = aggregatedOrderItems;
    }

    public AggregatedOrderInfo getAggregatedOrderInfo() {
        return aggregatedOrderInfo;
    }

    public List<AggregatedOrderItem> getAggregatedOrderItems() {
        return aggregatedOrderItems;
    }
}
