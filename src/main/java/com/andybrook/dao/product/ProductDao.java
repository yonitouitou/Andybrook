package com.andybrook.dao.product;

import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDao implements IProductDao {

    @Autowired
    private IProductRepository repository;

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Optional<Product> get(ProductId id) {
        return repository.findById(id.get());
    }

    @Override
    public Optional<Product> getByBarCode(BarCode barCode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Product> getByName(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isExist(ProductId id) {
        return repository.existsById(id.get());
    }

    @Override
    public List<Product> getByNameContaining(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(ProductId id) {
        repository.deleteById(id.get());
        return true;
    }
}
