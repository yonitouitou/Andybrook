package com.andybrook.dao.stock.productitem;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.order.IOrderItemDao;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductItemDao implements IProductItemDao {

    @Autowired
    private IProductItemRepository repository;
    @Autowired
    private EntityFactory entityFactory;
    @Autowired
    private IOrderItemDao orderItemDao;

    @Override
    public void save(ProductItem productItem) {
        repository.save(productItem);
    }

    @Override
    public int getProductItemSize(ProductId productId) {
        return repository.countByProductId(productId.get());
    }

    @Override
    public ProductItem delete(long id) {
        return null;
    }

    @Override
    public Optional<ProductItem> get(long id) {
        return repository.findById(id);
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
