package com.andybrook.model.notification.request.ctx;

import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.order.Order;

import java.time.ZonedDateTime;

public class OrderDocumentCtx extends DocumentCtx {

    private final boolean isLiveEvent;
    private final Order order;
    private final AggregatedOrder aggregatedOrder;

    private OrderDocumentCtx(boolean isLiveEvent, Order order, AggregatedOrder aggregatedOrder, ZonedDateTime dateDocument) {
        super(dateDocument);
        this.isLiveEvent = isLiveEvent;
        this.order = order;
        this.aggregatedOrder = aggregatedOrder;
    }

    public static Builder builder(boolean isLiveEvent, Order order, AggregatedOrder aggregatedOrder) {
        return new Builder(isLiveEvent, order, aggregatedOrder);
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
        private AggregatedOrder aggregatedOrder;
        private ZonedDateTime dateDocument;

        private Builder(boolean isLiveEvent, Order order, AggregatedOrder aggregatedOrder) {
            this.isLiveEvent = isLiveEvent;
            this.order = order;
        }

        public OrderDocumentCtx build() {
            return new OrderDocumentCtx(isLiveEvent, order, aggregatedOrder, dateDocument);
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
