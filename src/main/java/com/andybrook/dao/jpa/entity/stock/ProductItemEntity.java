package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "producttype")
@Table(name = "product_stock_item")
public abstract class ProductItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "productid")
    private ProductEntity productEntity;

    @Transient
    @Column(name = "producttype")
    protected ProductType productType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "barcodeid")
    protected BarCodeEntity barCodeEntity;

    @CreatedDate
    @Column(name = "createddatetime", nullable = false, updatable = false)
    protected LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime")
    protected LocalDateTime lastModifiedDatetime;

    protected abstract ProductType getProductType();

    public ProductItemEntity(ProductEntity productEntity, BarCodeEntity barCodeEntity, LocalDateTime createdDatetime, LocalDateTime lastModifiedDatetime) {
        this.productEntity = productEntity;
        this.productType = getProductType();
        this.barCodeEntity = barCodeEntity;
        this.createdDatetime = createdDatetime;
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public BarCodeEntity getBarCodeEntity() {
        return barCodeEntity;
    }

    public void setBarCodeEntity(BarCodeEntity barCodeEntity) {
        this.barCodeEntity = barCodeEntity;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public LocalDateTime getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(LocalDateTime lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }
}
