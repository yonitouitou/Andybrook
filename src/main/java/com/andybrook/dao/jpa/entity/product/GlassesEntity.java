package com.andybrook.dao.jpa.entity.product;

import com.andybrook.enums.ProductType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.andybrook.dao.jpa.entity.product.GlassesEntity.DISCRIMINATOR_VALUE_GLASSES;

@Entity
@DiscriminatorValue(DISCRIMINATOR_VALUE_GLASSES)
@Table(name="product_glasses")
public class GlassesEntity extends ProductEntity {

    static final String DISCRIMINATOR_VALUE_GLASSES = "GLASSES";

    private GlassesEntity() {
        super();
    }

    GlassesEntity(Long id, String name, double price, int quantityCreated, int quantityUsed) {
        super(id, name, price, ProductType.GLASSES, quantityCreated, quantityUsed);
    }
}
