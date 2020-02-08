package com.andybrook.dao.product;

import com.andybrook.model.product.ProductId;
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
