package com.andybrook.dao.product.glasses;

import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.product.GlassesEntity;
import com.andybrook.dao.product.glasses.jpa.IProductCrudRepository;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.model.Glasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GlassesDao implements IGlassesDao {

    @Autowired
    private IProductCrudRepository productCrudRepository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Optional<Glasses> getGlasses(Long id) {
        Optional<Glasses> glassesOpt = Optional.empty();
        Optional<ProductEntity> productEntityOpt = productCrudRepository.findById(id);
        if (productEntityOpt.isPresent()) {
            Glasses glasses = entityFactory.createProduct(productEntityOpt.get());
            glassesOpt = Optional.of(glasses);
        }
        return glassesOpt;
    }

    @Override
    public Glasses updateGlasses(Glasses glasses) {
        GlassesEntity entity = entityFactory.createProductEntity(glasses);
        GlassesEntity savedEntity = productCrudRepository.save(entity);
        glasses.setId(savedEntity.getId());
        return glasses;
    }

    @Override
    public boolean removeGlasses(long id) {
        productCrudRepository.deleteById(id);
        return true;
    }
}
