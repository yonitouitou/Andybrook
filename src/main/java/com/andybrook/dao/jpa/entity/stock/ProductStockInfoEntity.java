package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.product.ProductEntity;

import javax.persistence.*;

@Entity
@Table(name = "product_stock_info")
public class ProductStockInfoEntity {

    @Id
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productid")
    private ProductEntity productEntity;

    @Column(name = "quantitycreated")
    private int quantityCreated;

    @Column(name = "quantityused")
    private int quantityUsed;

    public ProductStockInfoEntity() {
    }

    public ProductStockInfoEntity(ProductEntity productEntity, int quantityCreated, int quantityUsed) {
        this.id = productEntity.getId();
        this.productEntity = productEntity;
        this.quantityCreated = quantityCreated;
        this.quantityUsed = quantityUsed;
    }

    public int getQuantityCreated() {
        return quantityCreated;
    }

    public void setQuantityCreated(int quantityCreated) {
        this.quantityCreated = quantityCreated;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
