package com.andybrook.dao.jpa.crudrepository;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Long> {

    String ENTITY_NAME = "ProductEntity";
    List<ProductEntity> findByNameContaining(String name);

    String GET_PRODUCT_ID_AND_NAMES_WITH_QUANTITY_MORE_THAN =
            "SELECT " +
                "id, name " +
            "FROM " +
                ENTITY_NAME +
            " WHERE " +
                "quantityCreated > :quantityCreated";

    @Query(value = GET_PRODUCT_ID_AND_NAMES_WITH_QUANTITY_MORE_THAN)
    List<Object> getAllProductNamesWithQuantityMoreThan(@Param("quantityCreated") int quantity);
}
