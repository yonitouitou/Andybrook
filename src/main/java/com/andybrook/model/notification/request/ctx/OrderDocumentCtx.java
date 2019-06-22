package com.andybrook.model.notification.request.ctx;

import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.order.Order;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderDocumentCtx extends DocumentCtx {

    private final boolean isLiveEvent;
    private final Order order;
    private final AggregatedOrder aggregatedOrder;

    private OrderDocumentCtx(boolean isLiveEvent, Order order, ZonedDateTime dateDocument) {
        super(dateDocument);
        this.isLiveEvent = isLiveEvent;
        this.order = order;
        this.aggregatedOrder = order.aggregate();
    }

    public static Builder builder(boolean isLiveEvent, Order order) {
        return new Builder(isLiveEvent, order);
    }

    public Order getOrder() {
        return order;
    }

    public AggregatedOrder getAggregatedOrder() {
        return aggregatedOrder;
    }

    public boolean isLiveEvent() {
        return isLiveEvent;
    }

    public static class Builder {

        private boolean isLiveEvent;
        private Order order;
        private ZonedDateTime dateDocument;

        private Builder(boolean isLiveEvent, Order order) {
            this.isLiveEvent = isLiveEvent;
            this.order = order;
        }

        public OrderDocumentCtx build() {
            return new OrderDocumentCtx(isLiveEvent, order, dateDocument);
        }

        public ZonedDateTime getDateDocument() {
            return dateDocument;
        }

        public Order getOrder() {
            return order;
        }

        public Builder setDateDocument(ZonedDateTime dateDocument) {
            this.dateDocument = dateDocument;
            return this;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDocumentCtx{");
        sb.append("isLiveEvent=").append(isLiveEvent);
        sb.append(", order=").append(order);
        sb.append(", aggregatedOrder=").append(aggregatedOrder);
        sb.append(", dateDocument=").append(dateDocument);
        sb.append('}');
        return sb.toString();
    }
}
