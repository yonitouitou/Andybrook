package com.andybrook.dao.product;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductStockInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductStockInfoDao implements IProductStockInfoDao {

    @Autowired
    private ElasticsearchOperations template;
    @Autowired
    private IProductStockInfoRepository repository;

    @Override
    public void save(ProductStockInfo productStockInfo) {
        repository.save(productStockInfo);
    }

    @Override
    public Optional<ProductStockInfo> get(ProductId productId) {
        return repository.findById(productId.get());
    }

    @Override
    public List<ProductStockInfo> getAllProductNamesWithQuantityMoreThan(int quantity) {
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("quantity").greaterThan(quantity)
        );
        return template.queryForList(query, ProductStockInfo.class);
    }
}
