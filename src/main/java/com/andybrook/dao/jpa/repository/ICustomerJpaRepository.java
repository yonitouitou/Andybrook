package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

    String CUSTOMER_TABLE_NAME = "customer";
    String STORE_TABLE_NAME = "store";
    String COLUMN_CUSTOMER_ID = "id";
    String COLUMN_STORE_ID = "id";
    String COLUMN_STORE_NAME = "name";

    String STORE_NAME_CONTAINING_QUERY =
            "SELECT " +
                    "*" +
            " FROM " +
                    CUSTOMER_TABLE_NAME + " as c" +
            " INNER JOIN " +
                    STORE_TABLE_NAME + " as s " +
            " ON " +
                    "c." + COLUMN_CUSTOMER_ID + " = s." + COLUMN_STORE_ID +
            " WHERE " +
                    "s." + COLUMN_STORE_NAME +
            " IS LIKE " +
                    "%:input%";

    @Query(value = STORE_NAME_CONTAINING_QUERY, nativeQuery = true)
    List<CustomerEntity> getCustomerByNameContaining(@Param("input") String input);






}
