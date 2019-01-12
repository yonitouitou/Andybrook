package com.andybrook.dao.stock.jpa;

import com.andybrook.model.Glasses;
import com.andybrook.model.GlassesStockItem;

import javax.persistence.*;

@Entity
@Table(name="stock_glasses")
public class GlassesStockItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="glassesid")
    private Long glassesId;
    @Column(name="quantity")
    private double quantity;

    private GlassesStockItemEntity() {
    }

    private GlassesStockItemEntity(Long id, Long glassesId, double quantity) {
        this.id = id;
        this.glassesId = glassesId;
        this.quantity = quantity;
    }

    public static GlassesStockItemEntity toEntity(GlassesStockItem item) {
        return new GlassesStockItemEntity(item.getId(), item.getGlasses().getId(), item.getQuantity());
    }

    public static GlassesStockItem toModel(GlassesStockItemEntity entity, Glasses glasses) {
        return new GlassesStockItem(entity.getId(), glasses, entity.getQuantity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGlassesId() {
        return glassesId;
    }

    public void setGlassesId(long glassesId) {
        this.glassesId = glassesId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
