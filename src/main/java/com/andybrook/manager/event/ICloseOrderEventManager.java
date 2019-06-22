package com.andybrook.manager.event;

import com.andybrook.model.notification.event.OrderClosedEvent;

public interface ICloseOrderEventManager {

    void handleEvent(OrderClosedEvent event);
}
