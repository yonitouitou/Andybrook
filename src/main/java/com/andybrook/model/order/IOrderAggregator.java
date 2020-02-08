package com.andybrook.model.order;

import com.andybrook.model.api.AggregatedOrder;

public interface IOrderAggregator {

    AggregatedOrder aggregate(Order order);
}
