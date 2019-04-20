package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.stock.ProductStockInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductStockInfoCrudRepository extends CrudRepository<ProductStockInfoEntity, Long> {

    String ENTITY_NAME = "productStockInfoEntity";
    String GET_PRODUCT_ID_AND_NAMES_WITH_QUANTITY_MORE_THAN =
            "SELECT " +
                    "* " +
            "FROM " +
                    ENTITY_NAME +
            " WHERE " +
                    "quantityCreated - quantityUsed > :quantity";

    @Query(value = GET_PRODUCT_ID_AND_NAMES_WITH_QUANTITY_MORE_THAN, nativeQuery = true)
    List<Object> getAllProductNamesWithQuantityMoreThan(@Param("quantity") int quantity);
}
