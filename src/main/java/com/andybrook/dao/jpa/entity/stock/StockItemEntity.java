package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.enums.ProductType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_item")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "producttype")
@EntityListeners(AuditingEntityListener.class)
public abstract class StockItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name = "productid", referencedColumnName = "id", nullable = false)
    protected ProductEntity productEntity;

    @Transient
    @Column(name = "producttype")
    protected ProductType productType;

    @Column(name = "quantity")
    protected int quantity;

    @CreatedDate
    @Column(name = "createddatetime")
    protected LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime")
    protected LocalDateTime lastModifiedDatetime;

    protected StockItemEntity(Long id, ProductEntity productEntity, ProductType productType) {
        this.id = id;
        this.productEntity = productEntity;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
