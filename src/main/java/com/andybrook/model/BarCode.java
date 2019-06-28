package com.andybrook.model;

import java.util.Objects;
import java.util.UUID;

public class BarCode {

    private final String id;
    private boolean isUsed;

    public BarCode() {
        id = UUID.randomUUID().toString();
        isUsed = false;
    }

    public BarCode(String id) {
        this.id = id;
        isUsed = false;
    }

    public String getId() {
        return id;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarCode barCode = (BarCode) o;
        return Objects.equals(id, barCode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BarCode{" +
                "id='" + id + '\'' +
                ", isUsed=" + isUsed +
                '}';
    }
}

