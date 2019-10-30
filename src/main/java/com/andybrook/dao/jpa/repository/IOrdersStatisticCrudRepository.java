package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.order.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrdersStatisticCrudRepository extends CrudRepository<OrderEntity, Long> {

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
