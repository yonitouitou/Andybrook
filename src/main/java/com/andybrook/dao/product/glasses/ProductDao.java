package com.andybrook.dao.product.glasses;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.crudrepository.IProductCrudRepository;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
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
    public List<? extends Product> getByNameContaining(String name) {
        List<ProductEntity> productEntities = repository.findByNameContaining(name);
        List<Product> products = new LinkedList<>();
        for (ProductEntity entity : productEntities) {
            products.add(entityFactory.createProduct(entity));
        }
        return products;
    }

    @Override
    public List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity) {
        List<Object> productIdAndNameList = repository.getAllProductNamesWithQuantityMoreThan(quantity);
        List<Pair<Long, String>> products = new LinkedList<>();
        for (int i = 0; i < productIdAndNameList.size(); i++) {
            Object[] currentProduct = (Object[]) productIdAndNameList.get(i);
            Pair<Long, String> idAndName = Pair.of((Long) currentProduct[0], (String) currentProduct[1]);
            products.add(idAndName);
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