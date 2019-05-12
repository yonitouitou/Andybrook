package com.andybrook.model.notification.ctx;

import java.time.ZonedDateTime;

public class OrderDocumentCtx extends DocumentCtx {

    private final long orderId;

    private OrderDocumentCtx(long orderId, DocSetting setting) {
        super(setting);
        this.orderId = orderId;
    }

    public static Builder builder(boolean isLiveEvent, long orderId) {
        return new Builder(isLiveEvent, orderId);
    }

    public long getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDocumentCtx{");
        sb.append("orderId=").append(orderId);
        sb.append(((DocumentCtx) this).toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        private long orderId;
        private ZonedDateTime dateDocument;
        private boolean isLiveEvent;

        private Builder(boolean isLiveEvent, long orderId) {
            this.isLiveEvent = isLiveEvent;
            this.orderId = orderId;
        }

        public OrderDocumentCtx build() {
            DocSetting setting = new DocSetting(isLiveEvent, dateDocument);
            return new OrderDocumentCtx(orderId, setting);
        }

        public ZonedDateTime getDateDocument() {
            return dateDocument;
        }

        public long getOrderId() {
            return orderId;
        }

        public Builder setDateDocument(ZonedDateTime dateDocument) {
            this.dateDocument = dateDocument;
            return this;
        }

        public boolean isLiveEvent() {
            return isLiveEvent;
        }
    }
}
