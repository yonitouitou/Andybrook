package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.product.ProductEntity;

import javax.persistence.*;

@Entity
@Table(name = "product_barcodes")
public class BarCodeEntity {

    @Id
    private String id;

    @ManyToOne
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
    public String toString() {
        return "BarCodeEntity{" +
                "id='" + id + '\'' +
                ", productEntity=" + productEntity +
                '}';
    }
}
