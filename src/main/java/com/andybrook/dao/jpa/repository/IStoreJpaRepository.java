package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStoreJpaRepository extends JpaRepository<StoreEntity, Long> {

    String STORE_TABLE_NAME = "store";
    String COLUMN_STORE_NAME = "name";

    String STORE_NAME_CONTAINING_QUERY =
            "SELECT " +
                    "*" +
            " FROM " +
                    STORE_TABLE_NAME + " as s" +
            " WHERE " +
                    "s." + COLUMN_STORE_NAME +
                " LIKE " +
                    "%:input%";

    @Query(value = STORE_NAME_CONTAINING_QUERY, nativeQuery = true)
    List<StoreEntity> getStoreByNameContaining(@Param("input") String input);
}
