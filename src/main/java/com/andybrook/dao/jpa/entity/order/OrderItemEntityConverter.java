package com.andybrook.dao.jpa.entity.order;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.stock.ProductItemEntity;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.stock.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = OrderItem.class, entity = OrderItemEntity.class)
public class OrderItemEntityConverter implements IEntityConverter<OrderItem, OrderItemEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public OrderItem toModel(OrderItemEntity entity) {
        ProductItem productItem = entityFactory.createProductItem(entity.getProductItemEntity());
        OrderItem item = new OrderItem(entity.getId(), productItem);
        item.setCreatedDatetime(entity.getCreatedDatetime());
        item.setLastModifiedDatetime(entity.getLastModifiedDatetime());
        return item;
    }

    @Override
    public OrderItemEntity toEntity(OrderItem model) {
        throw new UnsupportedOperationException();
    }

    public OrderItemEntity toEntity(OrderEntity orderEntity, OrderItem model) {
        ProductItemEntity productItemEntity = entityFactory.createProductItemEntity(model.getProductItem());
        return new OrderItemEntity(model.getId(), orderEntity, productItemEntity);
    }
}
