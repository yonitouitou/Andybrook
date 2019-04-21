package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
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
public class ProductItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "productid")
    private ProductEntity productEntity;

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

    public ProductItemEntity(ProductEntity productEntity, LocalDateTime createdDatetime, LocalDateTime lastModifiedDatetime) {
        this.productEntity = productEntity;
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

    public OrderItemEntity getOrderItemEntity() {
        return orderItemEntity;
    }

    public void setOrderItemEntity(OrderItemEntity orderItemEntity) {
        this.orderItemEntity = orderItemEntity;
    }
}
