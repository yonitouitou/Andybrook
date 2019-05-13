package com.andybrook.model.notification.request.ctx;

import com.andybrook.model.order.Order;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

public class OrderDocumentCtx extends NotificationCtx {

    private final Order order;

    private OrderDocumentCtx(Order order, NotifSetting setting) {
        super(setting);
        this.order = order;
    }

    public static Builder builder(boolean isLiveEvent, Order order) {
        return new Builder(isLiveEvent, order);
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDocumentCtx{");
        sb.append("order=").append(order);
        sb.append(((NotificationCtx) this).toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        private Order order;
        private ZonedDateTime dateDocument;
        private List<String> emails;
        private boolean isLiveEvent;

        private Builder(boolean isLiveEvent, Order order) {
            this.isLiveEvent = isLiveEvent;
            this.order = order;
        }

        public OrderDocumentCtx build() {
            NotifSetting setting = new NotifSetting(isLiveEvent, dateDocument, emails);
            return new OrderDocumentCtx(order, setting);
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

        public boolean isLiveEvent() {
            return isLiveEvent;
        }

        public List<String> getEmails() {
            return emails;
        }

        public Builder setEmails(List<String> emails) {
            this.emails = emails != null ? emails : Collections.emptyList();
            return this;
        }
    }
}
