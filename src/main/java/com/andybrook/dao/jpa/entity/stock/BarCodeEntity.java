package com.andybrook.dao.jpa.entity.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_barcodes")
public class BarCodeEntity {

    @Id
    private String id;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "productstockitemid")
    @JsonIgnoreProperties("barCodeEntity")
    private ProductItemEntity productItemEntity;

    private BarCodeEntity() {
    }

    public BarCodeEntity(String id, ProductItemEntity productItemEntity) {
        this.id = id;
        this.productItemEntity = productItemEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductItemEntity getProductItemEntity() {
        return productItemEntity;
    }

    public void setProductItemEntity(ProductItemEntity productItemEntity) {
        this.productItemEntity = productItemEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarCodeEntity that = (BarCodeEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BarCodeEntity{" +
                "id='" + id +
                '}';
    }
}
