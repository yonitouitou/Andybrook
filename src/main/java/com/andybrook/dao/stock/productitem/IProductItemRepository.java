package com.andybrook.dao.stock.productitem;

import com.andybrook.model.stock.ProductItem;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductItemRepository extends ElasticsearchRepository<ProductItem, Long> {

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
            " LIMIT 1";

    @Query(value = SELECT_FREE_PRODUCT_ITEM_BY_PRODUCT_ID, nativeQuery = true)
    ProductItem getFreeProductItemOf(@Param("productId") long productId);

    String COUNT_BY_PRODUCT_ID_QUERY =
            "SELECT " +
                    "COUNT(*) " +
            "FROM " +
                    TABLE_NAME +
            " WHERE " +
                    COLUMN_PRODUCT_ID + " = :productId";

    @Query(value = COUNT_BY_PRODUCT_ID_QUERY, nativeQuery = true)
    int countByProductId(@Param("productId") long productId);

    String SELECT_BY_BAR_CODE_ID_QUERY =
            "SELECT " +
                    "* " +
            "FROM " +
                    TABLE_NAME +
            " WHERE " +
                    COLUMN_BAR_CODE + " = :barCodeId";

    @Query(value = SELECT_BY_BAR_CODE_ID_QUERY, nativeQuery = true)
    ProductItem findByBarCodeId(@Param("barCodeId") String barCodeId);
}
