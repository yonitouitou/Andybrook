package com.andybrook.dao.jpa.entity.stock;

import javax.persistence.*;

@Entity
@Table(name = "product_barcodes")
public class BarCodeEntity {

    @Id
    private String id;

    private BarCodeEntity() {
    }

    public BarCodeEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BarCodeEntity{" +
                "id='" + id + '\'' +
                '}';
    }
}
