package com.andybrook.dao.order;

import com.andybrook.model.order.OrderItem;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IOrderItemRepository extends ElasticsearchRepository<OrderItem, String> {

}
