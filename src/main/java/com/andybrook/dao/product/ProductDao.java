package com.andybrook.dao.product;

import com.andybrook.dao.jpa.repository.IProductCrudRepository;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDao implements IProductDao {

    @Autowired
    private IProductCrudRepository repository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = entityFactory.createProductEntity(product);
        ProductEntity savedEntity = repository.save(productEntity);
        return entityFactory.createProduct(savedEntity);
    }

    @Override
    public Optional<Product> get(Long id) {
        Optional<Product> glassesOpt = Optional.empty();
        Optional<ProductEntity> productEntityOpt = repository.findById(id);
        if (productEntityOpt.isPresent()) {
            Glasses glasses = entityFactory.createProduct(productEntityOpt.get());
            glassesOpt = Optional.of(glasses);
        }
        return glassesOpt;
    }

    @Override
    public Optional<Product> getByName(String name) {
        Optional<Product> productOpt = Optional.empty();
        Optional<ProductEntity> entityOpt = repository.findByName(name);
        if (entityOpt.isPresent()) {
            Product product = entityFactory.createProduct(entityOpt.get());
            productOpt = Optional.of(product);
        }
        return productOpt;
    }

    @Override
    public boolean isExist(long id) {
        return repository.existsById(id);
    }

    @Override
    public List<? extends Product> getByNameContaining(String name) {
        List<ProductEntity> productEntities = repository.findByNameContaining(name);
        List<Product> products = new LinkedList<>();
        for (ProductEntity entity : productEntities) {
            products.add(entityFactory.createProduct(entity));
        }
        return products;
    }

    @Override
    public Product update(Product glasses) {
        ProductEntity entity = entityFactory.createProductEntity(glasses);
        ProductEntity savedEntity = repository.save(entity);
        return entityFactory.createProduct(savedEntity);
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }
}
