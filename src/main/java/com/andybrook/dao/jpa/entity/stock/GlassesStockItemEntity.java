package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.enums.ProductType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.andybrook.dao.jpa.entity.stock.GlassesStockItemEntity.DISCRIMINATOR_VALUE_TYPE_GLASSES;

@Entity
@Table(name = "stock_item_glasses")
@DiscriminatorValue(DISCRIMINATOR_VALUE_TYPE_GLASSES)
public class GlassesStockItemEntity extends StockItemEntity {

    static final String DISCRIMINATOR_VALUE_TYPE_GLASSES = "GLASSES";

    public GlassesStockItemEntity(){
        super(null, null, ProductType.GLASSES, 0);
    }

    protected GlassesStockItemEntity(Long id, ProductEntity productEntity, int quantity) {
        super(id, productEntity, ProductType.GLASSES, quantity);
    }
}
