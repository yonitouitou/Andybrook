package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = OrderItem.class, entity = OrderItemEntity.class)
public class OrderItemEntityConverter implements IEntityConverter<OrderItem, OrderItemEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public OrderItem toModel(OrderItemEntity entity) {
        Product product = entityFactory.createProduct(entity.getProductEntity());
        OrderItem orderItem = new OrderItem(entity.getId(), product);
        if (entity.getBarCodeEntity() != null) {
            orderItem.setBarCode(entityFactory.createBarCode(entity.getBarCodeEntity()));
        }
        orderItem.setCreatedDatetime(entity.getCreatedDatetime());
        orderItem.setLastModifiedDatetime(entity.getLastModifiedDatetime());
        return orderItem;
    }

    @Override
    public OrderItemEntity toEntity(OrderItem model) {
        throw new UnsupportedOperationException();
    }

    public OrderItemEntity toEntity(OrderEntity orderEntity, OrderItem model) {
        OrderItemEntity entity = entityFactory.createOrderItemEntityByProductType(orderEntity, model);
        if (model.getBarCode() != null) {
            entity.setBarCodeEntity(entityFactory.createBarCodeEntity(entity.getProductEntity(), model.getBarCode()));
        }
        return entity;
    }
}
