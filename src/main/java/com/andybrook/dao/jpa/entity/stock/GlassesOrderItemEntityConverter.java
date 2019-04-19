package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.StockItemEntityConverterByProductType;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.product.GlassesEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StockItemEntityConverterByProductType(type = ProductType.GLASSES)
public class GlassesOrderItemEntityConverter implements IEntityConverter<OrderItem, GlassesOrderItemEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public OrderItem toModel(GlassesOrderItemEntity entity) {
        Product product = entityFactory.createProduct(entity.getProductEntity());
        OrderItem item = new OrderItem(entity.getId(), product);
        if (entity.getBarCodeEntity() != null) {
            item.setBarCode(entityFactory.createBarCode(entity.getBarCodeEntity()));
        }
        item.setCreatedDatetime(entity.getCreatedDatetime());
        item.setLastModifiedDatetime(entity.getLastModifiedDatetime());
        return item;
    }

    @Override
    public GlassesOrderItemEntity toEntity(OrderItem model) {
        throw new UnsupportedOperationException();
    }

    public GlassesOrderItemEntity toEntity(OrderEntity orderEntity, OrderItem model) {
        GlassesEntity glassesEntity = entityFactory.createProductEntity(model.getProduct());
        GlassesOrderItemEntity stockItemEntity = new GlassesOrderItemEntity(model.getId(), orderEntity, glassesEntity);
        if (model.getBarCode() != null) {
            stockItemEntity.setBarCodeEntity(entityFactory.createBarCodeEntity(glassesEntity, model.getBarCode()));
        }
        return stockItemEntity;
    }
}
