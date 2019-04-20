package com.andybrook.dao.jpa.crudrepository;

import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface IOrderItemCrudRepository extends CrudRepository<OrderItemEntity, Long> {

}
