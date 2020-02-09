package com.andybrook.dao.stock.productitem;

import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductItemDao implements IProductItemDao {

    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private IProductItemRepository repository;

    @Override
    public void save(ProductItem productItem) {
        repository.save(productItem);
    }

    @Override
    public Optional<ProductItem> get(long id) {
        return repository.get(id);
    }

    @Override
    public int getProductItemSize(ProductId productId) {
        return repository.countByProductId(productId);
    }

    @Override
    public boolean delete(long id) {
        return repository.delete(id);
    }

    @Override
    public Optional<ProductItem> findByBarCodeId(String barCodeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(ProductId productId) {
        throw new UnsupportedOperationException();
    }
}
