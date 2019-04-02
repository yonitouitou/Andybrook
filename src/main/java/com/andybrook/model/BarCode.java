package com.andybrook.model;

import java.util.Objects;
import java.util.UUID;

public class BarCode {

    private final String id;

    public BarCode() {
        id = UUID.randomUUID().toString();
    }

    public BarCode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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
                '}';
    }
}

