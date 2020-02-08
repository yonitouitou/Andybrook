package com.andybrook.dao.statistic;

import com.andybrook.model.order.Order;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrdersStatisticRepository extends ElasticsearchRepository<Order, Long> {

    String TABLE_NAME = "orders";

    String COUNT_ORDERS_OF_STORE_BY_STATUS_QUERY =
            "SELECT " +
                    "o.status, COUNT(*) " +
            "FROM " +
                    TABLE_NAME + " o " +
            "LEFT JOIN " +
                    "store s " +
                "ON " +
                    "s.id " +
            "WHERE " +
                    "o.storeId = s.id " +
                "AND " +
                    "s.id = :storeId " +
            "GROUP BY " +
                    "status";

    @Query(value = COUNT_ORDERS_OF_STORE_BY_STATUS_QUERY, nativeQuery = true)
    List<Object[]> getOrdersOfStoreByStatusCounter(@Param("storeId") long storeId);
}
