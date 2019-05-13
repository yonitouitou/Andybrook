package com.andybrook.model.notification.event;

import com.andybrook.model.api.AggregatedOrder;
import com.andybrook.model.notification.request.ctx.NotifSetting;

public class CloseOrderEvent extends AbstractEvent  {

    private final AggregatedOrder order;
    private final NotifSetting setting;

    public CloseOrderEvent(AggregatedOrder order, NotifSetting setting) {
        this.order = order;
        this.setting = setting;
    }

    public AggregatedOrder getOrder() {
        return order;
    }

    public NotifSetting getSetting() {
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
