package com.andybrook.model.notification.event.ctx;

import com.andybrook.model.api.AggregatedOrder;

public class CloseOrderEvent {

    private final AggregatedOrder order;

    public CloseOrderEvent(AggregatedOrder order) {
        this.order = order;
    }

    public AggregatedOrder getOrder() {
        return order;
    }
}
