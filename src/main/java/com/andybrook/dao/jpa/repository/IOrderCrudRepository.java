package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.order.OrderEntity;
import com.andybrook.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface IOrderCrudRepository extends JpaRepository<OrderEntity, Long> {

    String TABLE_NAME = "orders";
    String ENTITY_NAME = "OrderEntity";
    String COLUMN_ID = "id";
    String COLUMN_NAME = "name";
    String COLUMN_COMMENT = "comment";
    String COLUMN_STATUS = "status";
    String COLUMN_CREATED_DATETIME = "createddatetime";
    String COLUMN_CLOSE_DATETIME = "closeDatetime";
    String COLUMN_LAST_MODIFIED_DATE_TIME = "lastModifiedDatetime";
    String COLUMN_STORE_ID = "storeid";

    List<OrderEntity> findByName(String name);
    List<OrderEntity> findByNameContaining(String name);
    List<OrderEntity> findByIdIn(Collection<Long> ids);

    String UPDATE_EXISTING_ORDER_QUERY =
            "UPDATE " + ENTITY_NAME + " s SET " +
                    "s." + COLUMN_NAME + " = :name, " +
                    "s." + COLUMN_COMMENT + " = :comment " +
            "WHERE " +
                    "s." + COLUMN_ID + "= :id";

    @Modifying
    @Transactional
    @Query(value = UPDATE_EXISTING_ORDER_QUERY)
    void updateExistingOrder(@Param("id") long id,
                             @Param("name") String name,
                             @Param("comment") String comment);


    String UPDATE_STATUS_QUERY =
            "UPDATE " + ENTITY_NAME + " s SET " +
                    "s." + COLUMN_STATUS + " = :status, " +
                    "s." + COLUMN_CLOSE_DATETIME + " = :closeDatetime " +
            "WHERE " +
                    "s." + COLUMN_ID + "= :id";

    @Modifying
    @Transactional
    @Query(value = UPDATE_STATUS_QUERY)
    void closeOrder(@Param("id") long id, @Param("status") OrderStatus status, @Param("closeDatetime") LocalDateTime closeDatetime);

    String UPDATE_LAST_MODIFIED_DATE_TIME_QUERY =
            "UPDATE " + ENTITY_NAME + " s SET " +
                    "s." + COLUMN_LAST_MODIFIED_DATE_TIME + " = :lastModifiedDatetime " +
            "WHERE " +
                    "s." + COLUMN_ID + "= :id";

    @Modifying
    @Transactional
    @Query(value = UPDATE_LAST_MODIFIED_DATE_TIME_QUERY)
    void updateOrderAuditing(@Param("id") long orderId, @Param("lastModifiedDatetime") LocalDateTime lastModifiedDateTime);

    String SELECT_ORDERS_BY_STORE_QUERY =
            "SELECT " +
                    "o.* " +
            "FROM " +
                    TABLE_NAME + " o " +
            "LEFT JOIN " +
                    "store s " +
                "ON " +
                    "s.id " +
            "WHERE " +
                    "o.storeId = s.id " +
                "AND " +
                    "s.id = :storeId";

    @Query(value = SELECT_ORDERS_BY_STORE_QUERY, nativeQuery = true)
    List<OrderEntity> getOrdersByStore(@Param("storeId") long storeId);

    String SELECT_LAST_ORDERS_BY_STORE_QUERY =
            "SELECT " +
                    "o.* " +
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
            "ORDER BY " +
                    "o.createdDatetime " +
                "ASC " +
            "LIMIT :lastOrderNb";

    @Query(value = SELECT_LAST_ORDERS_BY_STORE_QUERY, nativeQuery = true)
    List<OrderEntity> getLastOrdersByStore(@Param("storeId") long storeId, @Param("lastOrderNb") int lastOrderNb);
}
