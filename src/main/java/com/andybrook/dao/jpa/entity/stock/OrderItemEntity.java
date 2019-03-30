package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.enums.ProductType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "order_item")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "producttype")
@EntityListeners(AuditingEntityListener.class)
public abstract class OrderItemEntity {

    @Id
    protected Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false,
            cascade = {CascadeType.PERSIST,
                        CascadeType.DETACH,
                        CascadeType.REFRESH,
                        CascadeType.REMOVE})
    @JoinColumn(name = "productid", referencedColumnName = "id", nullable = false)
    protected ProductEntity productEntity;

    @Transient
    @Column(name = "producttype")
    protected ProductType productType;

    @Column(name = "quantity")
    protected int quantity;

    @ManyToOne
    @JoinColumn(name = "orderid", nullable = false)
    protected OrderEntity orderEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "barcodeid", referencedColumnName = "id", nullable = true)
    protected BarCodeEntity barCodeEntity;

    @CreatedDate
    @Column(name = "createddatetime", updatable = false)
    protected LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime")
    protected LocalDateTime lastModifiedDatetime;

    protected OrderItemEntity(Long id, OrderEntity orderEntity, ProductEntity productEntity, ProductType productType, int quantity) {
        this.id = id;
        this.productEntity = productEntity;
        this.productType = productType;
        this.quantity = quantity;
        this.orderEntity = orderEntity;
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

    public BarCodeEntity getBarCodeEntity() {
        return barCodeEntity;
    }

    public void setBarCodeEntity(BarCodeEntity barCodeEntity) {
        this.barCodeEntity = barCodeEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
