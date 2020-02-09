package com.andybrook.dao.statistic;

import com.andybrook.model.order.Order;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IOrdersStatisticRepository extends ElasticsearchRepository<Order, Long> {
}
