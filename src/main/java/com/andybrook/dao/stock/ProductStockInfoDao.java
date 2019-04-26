package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.repository.IProductStockInfoCrudRepository;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.stock.ProductStockInfoEntity;
import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductStockInfoDao implements IProductStockInfoDao {

    @Autowired
    private IProductStockInfoCrudRepository repository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public ProductStockInfo update(ProductStockInfo productStockInfo) {
        ProductStockInfoEntity entity = entityFactory.createProductStockInfoEntity(productStockInfo);
        ProductStockInfoEntity entitySaved = repository.save(entity);
        return entityFactory.createProductStockInfo(entitySaved);
    }

    @Override
    public ProductStockInfo get(long productId) {
        ProductStockInfo productStockInfo = null;
        Optional<ProductStockInfoEntity> entityOpt = repository.findById(productId);
        if (entityOpt.isPresent()) {
            productStockInfo = entityFactory.createProductStockInfo(entityOpt.get());
        }
        return productStockInfo;
    }

    @Override
    public List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity) {
        List<Object> productIdAndNameList = repository.getAllProductNamesWithQuantityMoreThan(quantity);
        List<Pair<Long, String>> products = new LinkedList<>();
        for (int i = 0; i < productIdAndNameList.size(); i++) {
            Object[] currentProduct = (Object[]) productIdAndNameList.get(i);
            Pair<Long, String> idAndName = Pair.of(((BigInteger) currentProduct[0]).longValue(), (String) currentProduct[1]);
            products.add(idAndName);
        }
        return products;
    }
}
