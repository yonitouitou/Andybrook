package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = StockItem.class, entity = OrderItemEntity.class)
public class OrderItemEntityConverter implements IEntityConverter<StockItem, OrderItemEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public StockItem toModel(OrderItemEntity entity) {
        Product product = entityFactory.createProduct(entity.getProductEntity());
        StockItem stockItem = new StockItem(entity.getId(), product, entity.getProductType(), entity.getQuantity());
        if (entity.getBarCodeEntity() != null) {
            stockItem.setBarCode(entityFactory.createBarCode(entity.getBarCodeEntity()));
        }
        return stockItem;
    }

    @Override
    public OrderItemEntity toEntity(StockItem model) {
        throw new UnsupportedOperationException();
    }

    public OrderItemEntity toEntity(OrderEntity orderEntity, StockItem model) {
        OrderItemEntity entity = entityFactory.createOrderItemEntityByProductType(orderEntity, model);
        if (model.getBarCode() != null) {
            entity.setBarCodeEntity(entityFactory.createBarCodeEntity(entity.getProductEntity(), model.getBarCode()));
        }
        return entity;
    }
}
