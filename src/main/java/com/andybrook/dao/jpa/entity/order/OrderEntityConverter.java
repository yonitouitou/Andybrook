package com.andybrook.dao.jpa.entity.order;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.store.StoreEntity;
import com.andybrook.model.customer.Store;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@EntityConverter(model = Order.class, entity = OrderEntity.class)
public class OrderEntityConverter implements IEntityConverter<Order, OrderEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Order toModel(OrderEntity entity) {
        Store customer = entityFactory.createStore(entity.getStoreEntity());
        Order order = new Order(entity.getId(), entity.getName(), customer);
        order.setStatus(entity.getStatus());
        order.setComment(entity.getComment());
        order.setCreatedDateTime(entity.getCreatedDatetime());
        order.setLastModifiedDateTime(entity.getLastModifiedDatetime());
        order.setCloseDateTime(entity.getCloseDatetime());
        for (OrderItemEntity orderItemEntity : entity.getItems()) {
            OrderItem orderItem = entityFactory.createOrderItem(orderItemEntity);
            order.addOrderItem(orderItem);
        }
        return order;
    }

    @Override
    public OrderEntity toEntity(Order model) {
        StoreEntity storeEntity = entityFactory.createStoreEntity(model.getStore());
        OrderEntity orderEntity = new OrderEntity(model.getId(), model.getName(), storeEntity,
                model.getStatus(), model.getComment(), model.getCreatedDateTime(), model.getCloseDateTime());
        List<OrderItemEntity> items = model.getItems()
                .stream()
                .map(s -> entityFactory.createOrderItemEntityByProductType(orderEntity, s))
                .collect(Collectors.toList());
        orderEntity.setItems(items);
        return orderEntity;
    }
}
