package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.StockItemEntityConverterByProductType;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.product.GlassesEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Glasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StockItemEntityConverterByProductType(type = ProductType.GLASSES)
public class GlassesStockItemEntityConverter implements IEntityConverter<StockItem<Glasses>, GlassesOrderItemEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public StockItem<Glasses> toModel(GlassesOrderItemEntity entity) {
        Glasses glasses = entityFactory.createProduct(entity.getProductEntity());
        StockItem<Glasses> item = new StockItem(entity.getId(), glasses, ProductType.GLASSES, entity.getQuantity());
        if (entity.getBarCodeEntity() != null) {
            item.setBarCode(entityFactory.createBarCode(entity.getBarCodeEntity()));
        }
        return item;
    }

    @Override
    public GlassesOrderItemEntity toEntity(StockItem<Glasses> model) {
        throw new UnsupportedOperationException();
    }

    public GlassesOrderItemEntity toEntity(OrderEntity orderEntity, StockItem<Glasses> model) {
        GlassesEntity glassesEntity = entityFactory.createProductEntity(model.getProduct());
        GlassesOrderItemEntity stockItemEntity = new GlassesOrderItemEntity(model.getId(), orderEntity, glassesEntity, model.getQuantity());
        if (model.getBarCode() != null) {
            stockItemEntity.setBarCodeEntity(entityFactory.createBarCodeEntity(glassesEntity, model.getBarCode()));
        }
        return stockItemEntity;
    }
}
