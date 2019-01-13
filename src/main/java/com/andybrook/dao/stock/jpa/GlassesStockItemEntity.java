package com.andybrook.dao.stock.jpa;

import com.andybrook.dao.glasses.jpa.GlassesEntity;
import com.andybrook.model.GlassesStockItem;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="stock_glasses")
@EntityListeners(AuditingEntityListener.class)
public class GlassesStockItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "glassesid", nullable = false, referencedColumnName = "id")
    private GlassesEntity glassesEntity;

    @Column(name="quantity")
    private double quantity;

    @CreatedDate
    @Column(name = "createddatetime", nullable = false)
    private LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime", nullable = false)
    private LocalDateTime lastModifiedDateTime;

    public GlassesStockItemEntity() {
    }

    private GlassesStockItemEntity(Long id, GlassesEntity glassesEntity, double quantity) {
        this.id = id;
        this.glassesEntity = glassesEntity;
        this.quantity = quantity;
    }

    public static GlassesStockItemEntity toEntity(GlassesStockItem item) {
        return new GlassesStockItemEntity(item.getId(), GlassesEntity.toEntity(item.getGlasses()), item.getQuantity());
    }

    public static GlassesStockItem toModel(GlassesStockItemEntity entity) {
        return new GlassesStockItem(entity.getId(), GlassesEntity.toModel(entity.getGlassesEntity()), entity.getQuantity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GlassesEntity getGlassesEntity() {
        return glassesEntity;
    }

    public void setGlassesEntity(GlassesEntity glassesEntity) {
        this.glassesEntity = glassesEntity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }
}
