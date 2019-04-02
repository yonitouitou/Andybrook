package com.andybrook.dao.jpa.crudrepository;

import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.dao.jpa.entity.stock.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Long> {

    String ENTITY_NAME = "ProductEntity";
    List<ProductEntity> findByNameContaining(String name);

    String GET_PRODUCT_NAMES_WITH_QUANTITY_MORE_THAN =
            "SELECT " +
                "name " +
            "FROM " +
                ENTITY_NAME +
            " WHERE " +
                "quantity > :quantity";

    @Query(value = GET_PRODUCT_NAMES_WITH_QUANTITY_MORE_THAN)
    List<String> getAllProductNamesWithQuantityMoreThan(@Param("quantity") int quantity);
}
