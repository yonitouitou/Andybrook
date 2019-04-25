package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.stock.ProductItemEntity;
import com.andybrook.dao.jpa.repository.IProductItemCrudRepository;
import com.andybrook.model.stock.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductItemDao implements IProductItemDao {

    @Autowired
    private IProductItemCrudRepository repository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public ProductItem update(ProductItem productItem) {
        ProductItemEntity entity = entityFactory.createProductItemEntity(productItem);
        ProductItemEntity savedEntity = repository.save(entity);
        return entityFactory.createProductItem(savedEntity);
    }

    @Override
    public ProductItem delete(long id) {
        return null;
    }

    @Override
    public Optional<ProductItem> find(long id) {
        Optional<ProductItem> productItemOpt = Optional.empty();
        Optional<ProductItemEntity> entityOpt = repository.findById(id);
        if (entityOpt.isPresent()) {
            productItemOpt = Optional.of(entityFactory.createProductItem(entityOpt.get()));
        }
        return productItemOpt;
    }
}
