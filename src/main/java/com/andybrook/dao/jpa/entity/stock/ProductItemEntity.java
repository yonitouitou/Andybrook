package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_stock_item")
@EntityListeners(AuditingEntityListener.class)
public class ProductItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "productid")
    protected ProductEntity productEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "barcodeid")
    protected BarCodeEntity barCodeEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderitemid")
    protected OrderItemEntity orderItemEntity;

    @CreatedDate
    @Column(name = "createddatetime", nullable = false, updatable = false)
    protected LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime")
    protected LocalDateTime lastModifiedDatetime;

    private ProductItemEntity() {}


    public ProductItemEntity(Long id, LocalDateTime createdDatetime, LocalDateTime lastModifiedDatetime) {
        this.id = id;
        this.createdDatetime = createdDatetime;
        this.lastModifiedDatetime = lastModifiedDatetime;
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

    public OrderItemEntity getOrderItemEntity() {
        return orderItemEntity;
    }

    public void setOrderItemEntity(OrderItemEntity orderItemEntity) {
        this.orderItemEntity = orderItemEntity;
    }
}
