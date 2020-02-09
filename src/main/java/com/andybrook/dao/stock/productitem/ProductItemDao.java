package com.andybrook.dao.stock.productitem;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Repository;

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
    public int getProductItemSize(ProductId productId) {
        return (int) template.count(new CriteriaQuery(
                new Criteria("productId").is(productId.get()))
        );
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Optional<ProductItem> findByBarCode(BarCode barCode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(ProductId productId) {
        throw new UnsupportedOperationException();
    }
}
