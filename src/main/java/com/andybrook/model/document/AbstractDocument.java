package com.andybrook.model.document;

import com.andybrook.enums.DocType;

import java.time.LocalDateTime;

public abstract class AbstractDocument {

    protected final Long id;
    protected final byte[] data;
    protected final LocalDateTime createdDatetime;

    public abstract DocType getType();

    public AbstractDocument(Long id, byte[] data, LocalDateTime createdDatetime) {
        this.id = id;
        this.data = data;
        this.createdDatetime = createdDatetime;
    }

    public AbstractDocument(byte[] data) {
        this.id = null;
        this.createdDatetime = null;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }
}
