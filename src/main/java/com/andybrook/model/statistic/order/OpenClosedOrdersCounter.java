package com.andybrook.model.statistic.order;

import com.andybrook.enums.OrderStatus;

import java.util.EnumMap;
import java.util.Map;

public class OpenClosedOrdersCounter {

    private static final OpenClosedOrdersCounter ZERO = new OpenClosedOrdersCounter();
    private final Map<OrderStatus, Long> counters = new EnumMap<>(OrderStatus.class);

    public OpenClosedOrdersCounter() {}

    public void addCounter(OrderStatus status, long counter) {
        counters.put(status, counter);
    }

    public static OpenClosedOrdersCounter zero() {
        return ZERO;
    }

    public Map<OrderStatus, Long> getCounters() {
        return counters;
    }
}
