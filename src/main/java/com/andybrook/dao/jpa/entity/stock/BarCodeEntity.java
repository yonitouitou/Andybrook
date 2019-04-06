package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.product.ProductEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_barcodes")
public class BarCodeEntity {

    @Id
    private String id;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "productid")
    private ProductEntity productEntity;

    private BarCodeEntity() {
    }

    public BarCodeEntity(String id, ProductEntity productEntity) {
        this.id = id;
        this.productEntity = productEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
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
