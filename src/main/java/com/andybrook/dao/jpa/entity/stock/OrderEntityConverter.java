package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.customer.CustomerEntity;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.customer.Customer;
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
        Customer customer = entityFactory.createCustomer(entity.getCustomerEntity());
        Order order = new Order(entity.getId(), entity.getName(), customer);
        order.setStatus(entity.getStatus());
        order.setComment(entity.getComment());
        order.setCreatedDateTime(entity.getCreatedDatetime());
        order.setCloseDateTime(entity.getCloseDatetime());
        for (OrderItemEntity orderItemEntity : entity.getItems()) {
            OrderItem orderItem = entityFactory.createOrderItem(orderItemEntity);
            order.addItem(orderItem);
        }
        return order;
    }

    @Override
    public OrderEntity toEntity(Order model) {
        CustomerEntity customerEntity = entityFactory.createCustomerEntity(model.getCustomer());
        OrderEntity orderEntity = new OrderEntity(model.getId(), model.getName(), customerEntity,
                model.getStatus(), model.getComment(), model.getCreatedDateTime(), model.getCloseDateTime());
        List<OrderItemEntity> items = model.getItems()
                .stream()
                .map(s -> entityFactory.createOrderItemEntityByProductType(orderEntity, s))
                .collect(Collectors.toList());
        orderEntity.setItems(items);
        return orderEntity;
    }
}
