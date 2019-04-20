package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.order.OrderEntity;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.enums.ProductType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDateTime;

import static com.andybrook.dao.jpa.entity.stock.GlassesItemEntity.DISCRIMINATOR_VALUE_TYPE_GLASSES;

@Entity
@Table(name = "order_item_glasses")
@DiscriminatorValue(DISCRIMINATOR_VALUE_TYPE_GLASSES)
public class GlassesItemEntity extends ProductItemEntity {

    static final String DISCRIMINATOR_VALUE_TYPE_GLASSES = "GLASSES";

    public GlassesItemEntity(ProductEntity productEntity, BarCodeEntity barCodeEntity, LocalDateTime createdDatetime,
                             LocalDateTime lastModifiedDatetime) {
        super(productEntity, barCodeEntity, createdDatetime, lastModifiedDatetime);
    }

    @Override
    protected ProductType getProductType() {
        return ProductType.GLASSES;
    }
}
