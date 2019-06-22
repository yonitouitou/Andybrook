package com.andybrook.model.notification.event;

import com.andybrook.model.order.Order;

public class OrderClosedEvent extends AbstractEvent  {

    private final Order order;

    public OrderClosedEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderClosedEvent{");
        sb.append("order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
