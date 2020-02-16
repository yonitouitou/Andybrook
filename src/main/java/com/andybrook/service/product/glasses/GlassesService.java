package com.andybrook.service.product.glasses;

import com.andybrook.dao.product.IGlassesDao;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.service.product.IProductTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlassesService implements IProductTypeService {

    @Autowired
    private IGlassesDao dao;

    @Override
    public void save(Product product) {
        dao.save((Glasses) product);
    }

    @Override
    public Product get(ProductId id) {
        Optional<Glasses> glassesOpt = dao.get(id);
        return glassesOpt.orElse(null);
    }

    @Override
    public boolean isExist(ProductId id) {
        return dao.isExist(id);
    }

    @Override
    public Product getByName(String name) {
        Optional<Glasses> glassesOpt = dao.getByName(name);
        return glassesOpt.orElse(null);
    }

    @Override
    public List<? extends Product> getByNameContaining(String subName) {
        return dao.getByNameContaining(subName);
    }
}
