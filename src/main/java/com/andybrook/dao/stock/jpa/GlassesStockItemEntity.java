package com.andybrook.dao.stock.jpa;

import com.andybrook.dao.glasses.jpa.GlassesEntity;
import com.andybrook.model.Glasses;
import com.andybrook.model.GlassesStockItem;

import javax.persistence.*;

@Entity
@Table(name="stock_glasses")
public class GlassesStockItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "glassesid", nullable = false, referencedColumnName = "id")
    private GlassesEntity glassesEntity;

    @Column(name="quantity")
    private double quantity;

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
}
