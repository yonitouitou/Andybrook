package com.andybrook.dao.product;

import com.andybrook.model.stock.ProductStockInfo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductStockInfoRepository extends ElasticsearchRepository<ProductStockInfo, Long> {

    String TABLE_NAME = "product_stock_info";
    String PRODUCT_TABLE_NAME = "product";
    String GET_PRODUCT_ID_AND_NAMES_WITH_QUANTITY_MORE_THAN =
            "SELECT " +
                    "p.id, p.name " +
            "FROM " +
                    PRODUCT_TABLE_NAME + " p " +
            "LEFT JOIN " +
                    TABLE_NAME + " psi " +
            "ON p.id = psi.id " +
            "WHERE " +
                    "quantityCreated - quantityUsed > :quantity";

    @Query(value = GET_PRODUCT_ID_AND_NAMES_WITH_QUANTITY_MORE_THAN, nativeQuery = true)
    List<Object> getAllProductNamesWithQuantityMoreThan(@Param("quantity") int quantity);
}
