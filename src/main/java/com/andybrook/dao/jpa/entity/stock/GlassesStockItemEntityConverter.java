package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.StockItemEntityConverterByProductType;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.product.GlassesEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Glasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StockItemEntityConverterByProductType(type = ProductType.GLASSES)
public class GlassesStockItemEntityConverter implements IEntityConverter<OrderItem<Glasses>, GlassesOrderItemEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public OrderItem<Glasses> toModel(GlassesOrderItemEntity entity) {
        Glasses glasses = entityFactory.createProduct(entity.getProductEntity());
        OrderItem<Glasses> item = new OrderItem(entity.getId(), glasses, ProductType.GLASSES, entity.getQuantity());
        if (entity.getBarCodeEntity() != null) {
            item.setBarCode(entityFactory.createBarCode(entity.getBarCodeEntity()));
        }
        item.setCreatedDatetime(entity.getCreatedDatetime());
        item.setLastModifiedDatetime(entity.getLastModifiedDatetime());
        return item;
    }

    @Override
    public GlassesOrderItemEntity toEntity(OrderItem<Glasses> model) {
        throw new UnsupportedOperationException();
    }

    public GlassesOrderItemEntity toEntity(OrderEntity orderEntity, OrderItem<Glasses> model) {
        GlassesEntity glassesEntity = entityFactory.createProductEntity(model.getProduct());
        GlassesOrderItemEntity stockItemEntity = new GlassesOrderItemEntity(model.getId(), orderEntity, glassesEntity, model.getQuantity());
        if (model.getBarCode() != null) {
            stockItemEntity.setBarCodeEntity(entityFactory.createBarCodeEntity(glassesEntity, model.getBarCode()));
        }
        return stockItemEntity;
    }
}
