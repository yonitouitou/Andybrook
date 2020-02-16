package com.andybrook.dao.stock.productitem;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductItemDao implements IProductItemDao {

    @Autowired
    private ElasticsearchOperations template;
    @Autowired
    private IProductItemRepository repository;

    @Override
    public void save(ProductItem productItem) {
        repository.save(productItem);
    }

    @Override
    public Optional<ProductItem> get(long id) {
        return repository.findById(id);
    }

    @Override
    public boolean exist(long id) {
        return repository.existsById(id);
    }

    @Override
    public int getProductItemSize(ProductId productId) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withIndices("product_items")
                .withQuery(QueryBuilders.termQuery("productId.id", productId.get()))
                .build();
        return (int) template.count(query);
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Optional<ProductItem> findByBarCode(BarCode barCode) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withIndices("product_items")
                .withQuery(QueryBuilders.termQuery("barCode.id", barCode.get()))
                .withPageable(PageRequest.of(0, 1))
                .build();
        List<ProductItem> productItems = template.queryForList(query, ProductItem.class);
        return ! productItems.isEmpty()
                ? Optional.of(productItems.get(0))
                : Optional.empty();
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(ProductId productId) {
        QueryBuilder query = QueryBuilders.boolQuery()
                .mustNot(QueryBuilders.existsQuery("orderItemId"));
        SearchQuery search = new NativeSearchQueryBuilder()
                .withQuery(query)
                .withPageable(PageRequest.of(0, 1))
                .build();
        List<ProductItem> productItems = template.queryForList(search, ProductItem.class);
        return productItems.isEmpty() ? Optional.empty() : Optional.ofNullable(productItems.get(0));
    }
}
