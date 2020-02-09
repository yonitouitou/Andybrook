package com.andybrook.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Objects;

@Document(indexName = "barcodes")
public class BarCode {

    @Id
    private final String id;
    private boolean isUsed;

    public BarCode() {
        id = null;
        isUsed = false;
    }

    public BarCode(String id) {
        this.id = id;
        isUsed = false;
    }

    public String get() {
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

