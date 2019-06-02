package com.andybrook.model.notification.event;

public interface IEventListener<T> {

    void handleEvent(T ctx);

    

}
