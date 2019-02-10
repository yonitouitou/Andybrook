package com.andybrook.model.notification.event.listener;

public interface IEventListener<T> {

    void handleEvent(T ctx);

    

}
