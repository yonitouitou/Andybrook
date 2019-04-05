package com.andybrook.model.request;

import com.andybrook.util.IdGenerator;

public abstract class AbstractRequest {

    private final long id;

    public AbstractRequest() {
        this.id = IdGenerator.generateId();
    }

    public long getId() {
        return id;
    }
}
