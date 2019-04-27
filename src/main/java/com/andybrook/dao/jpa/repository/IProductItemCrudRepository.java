package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.stock.ProductItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IProductItemCrudRepository extends CrudRepository<ProductItemEntity, Long> {

    String TABLE_NAME = "product_stock_item";
    String COLUMN_ORDER_ITEM_ID = "orderitemid";
    String COLUMN_PRODUCT_ID = "productid";
    String COLUMN_BAR_CODE = "barcodeid";

    String SELECT_FREE_PRODUCT_ITEM_BY_PRODUCT_ID =
            "SELECT " +
                    "* " +
            "FROM " +
                    TABLE_NAME +
            " WHERE " +
                    COLUMN_PRODUCT_ID + " = :productId" +
            " AND " +
                    COLUMN_ORDER_ITEM_ID + " IS NULL" +
            " AND " +
                    COLUMN_BAR_CODE + " IS NOT NULL" +
            " IS NULL LIMIT 1";

    @Query(value = SELECT_FREE_PRODUCT_ITEM_BY_PRODUCT_ID, nativeQuery = true)
    ProductItemEntity getFreeProductItemOf(@Param("productId") long productId);
}
