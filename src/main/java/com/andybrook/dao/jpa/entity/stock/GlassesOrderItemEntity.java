package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.enums.ProductType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.andybrook.dao.jpa.entity.stock.GlassesOrderItemEntity.DISCRIMINATOR_VALUE_TYPE_GLASSES;

@Entity
@Table(name = "order_item_glasses")
@DiscriminatorValue(DISCRIMINATOR_VALUE_TYPE_GLASSES)
public class GlassesOrderItemEntity extends OrderItemEntity {

    static final String DISCRIMINATOR_VALUE_TYPE_GLASSES = "GLASSES";

    public GlassesOrderItemEntity(){
        super(null, null,null, ProductType.GLASSES, 0);
    }

    protected GlassesOrderItemEntity(Long id, OrderEntity orderEntity, ProductEntity productEntity, int quantity) {
        super(id, orderEntity, productEntity, ProductType.GLASSES, quantity);
    }
}
