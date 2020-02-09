package com.andybrook.dao.stock.productitem;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.support.SimpleElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductItemRepository implements IProductItemRepository {

    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private SimpleElasticsearchRepository<ProductItem, Long> repository;

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

    @Override
    public void save(ProductItem productItem) {
        repository.save(productItem);
    }

    @Override
    public Optional<ProductItem> get(long id) {
        return repository.findById(id);
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public int countByProductId(ProductId id) {
        /*template.count(new CriteriaQuery(
                new Criteria("product.id")).
        )*/
        return 0;
    }
}
