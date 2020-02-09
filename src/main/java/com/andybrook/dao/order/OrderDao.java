package com.andybrook.dao.order;

import com.andybrook.exception.OrderNotFound;
import com.andybrook.model.order.Order;
import com.andybrook.model.request.order.UpdateOrderRequest;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDao implements IOrderDao {

    @Autowired
    private ElasticsearchOperations template;
    @Autowired
    private ElasticsearchRepository<Order, Long> repository;

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public Optional<Order> get(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Order> getByName(String name) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery("name", name))
                .withIndices("orders")
                .build();
        return template.queryForList(query, Order.class);
    }

    @Override
    public List<Order> getByNameContaining(String name) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.wildcardQuery("name", name))
                .withIndices("orders")
                .build();
        return template.queryForList(query, Order.class);
    }

    @Override
    public List<Order> getOrders(List<Long> ids) {
        Iterable<Order> orderIterable = repository.findAllById(ids);
        List<Order> orderList = new ArrayList<>();
        orderIterable.forEach(orderList::add);
        return orderList;

    }

    @Override
    public List<Order> getAll(int limit) {
        Pageable pageable = PageRequest.of(1, limit, Sort.by(Direction.DESC, "status", "lastModifiedDateTime"));
        CriteriaQuery query = new CriteriaQuery(new Criteria(), pageable);
        return template.queryForList(query, Order.class);
    }

    @Override
    public List<Order> getOrdersOfStore(long storeId) {
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("storeId").is(storeId)
        );
        return template.queryForList(query, Order.class);
    }

    @Override
    public List<Order> getLastOrdersOfStore(long storeId, int lastOrderNb) {
        Pageable pageable = PageRequest.of(1, lastOrderNb, Sort.by(Direction.DESC, "status", "lastModifiedDateTime"));
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("storeId").is(storeId),
                pageable
        );
        return template.queryForList(query, Order.class);
    }

    @Override
    public void updateOrderAudit(Order order) {

    }

    @Override
    public void updateOrder(UpdateOrderRequest request, boolean checkIfExist) throws OrderNotFound {

    }
}
