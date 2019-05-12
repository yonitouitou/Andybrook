package com.andybrook.model.notification.event.ctx;

import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.ctx.DocSetting;

public class CloseOrderEvent {

    private final AggregatedOrder order;
    private final DocSetting setting;

    public CloseOrderEvent(AggregatedOrder order, DocSetting setting) {
        this.order = order;
        this.setting = setting;
    }

    public AggregatedOrder getOrder() {
        return order;
    }

    public DocSetting getSetting() {
        return setting;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CloseOrderEvent{");
        sb.append("order=").append(order);
        sb.append(", setting=").append(setting);
        sb.append('}');
        return sb.toString();
    }
}
