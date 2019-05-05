package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
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
    @Autowired
    private IOrderItemDao orderItemDao;

    @Override
    public void update(ProductItem productItem) {
        OrderItemEntity orderItemEntity = null;
        if (productItem.getOrderItemIdOpt().isPresent()) {
            orderItemEntity = orderItemDao.getEntity(productItem.getOrderItemIdOpt().getAsLong());
        }
        ProductItemEntity entity = entityFactory.createProductItemEntity(productItem, orderItemEntity);
        ProductItemEntity savedEntity = repository.save(entity);
        productItem.setId(savedEntity.getId());
        productItem.setLastModifiedDatetime(savedEntity.getLastModifiedDatetime());
    }

    @Override
    public int getProductItemSize(long productId) {
        return repository.countByProductId(productId);
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

    @Override
    public Optional<ProductItem> findByBarCodeId(String barCodeId) {
        Optional<ProductItem> productItemOpt = Optional.empty();
        ProductItemEntity entity = repository.findByBarCodeId(barCodeId);
        if (entity != null) {
            productItemOpt = Optional.of(entityFactory.createProductItem(entity));
        }
        return productItemOpt;
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(long productId) {
        Optional<ProductItem> productItemOpt = Optional.empty();
        ProductItemEntity entity = repository.getFreeProductItemOf(productId);
        if (entity != null) {
            productItemOpt = Optional.of(entityFactory.createProductItem(entity));
        }
        return productItemOpt;
    }
}
