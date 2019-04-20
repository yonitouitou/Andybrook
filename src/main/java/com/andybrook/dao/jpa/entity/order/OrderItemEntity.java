package com.andybrook.dao.jpa.entity.order;

import com.andybrook.dao.jpa.entity.stock.ProductItemEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_item")
@EntityListeners(AuditingEntityListener.class)
public class OrderItemEntity {

    @Id
    protected Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false,
            cascade = {CascadeType.PERSIST,
                        CascadeType.DETACH,
                        CascadeType.REFRESH,
                        CascadeType.MERGE})
    @JoinColumn(name = "productitemid", referencedColumnName = "id", nullable = false)
    protected ProductItemEntity productItemEntity;

    @ManyToOne
    @JoinColumn(name = "orderid", nullable = false)
    protected OrderEntity orderEntity;

    @CreatedDate
    @Column(name = "createddatetime", updatable = false)
    protected LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime")
    protected LocalDateTime lastModifiedDatetime;

    protected OrderItemEntity(Long id, OrderEntity orderEntity, ProductItemEntity productItemEntity) {
        this.id = id;
        this.productItemEntity = productItemEntity;
        this.orderEntity = orderEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductItemEntity getProductItemEntity() {
        return productItemEntity;
    }

    public void setProductItemEntity(ProductItemEntity productItemEntity) {
        this.productItemEntity = productItemEntity;
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

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
