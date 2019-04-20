package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface IOrderItemCrudRepository extends CrudRepository<OrderItemEntity, Long> {

}
