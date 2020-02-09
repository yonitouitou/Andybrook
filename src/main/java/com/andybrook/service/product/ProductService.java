package com.andybrook.service.product;

import com.andybrook.dao.product.IProductDao;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.service.stock.IProductStockInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDao dao;
    @Autowired
    private IProductStockInfoService productStockInfoService;

    @Override
    public Product get(ProductId id) {
        Product product = null;
        Optional<Product> productOpt = dao.get(id);
        if (productOpt.isPresent()) {
            product = productOpt.get();
        }
        return product;
    }

    @Override
    public Optional<Product> getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public boolean isExist(ProductId id) {
        return dao.isExist(id);
    }

    @Override
    public List<Product> getByNameContaining(String subName) {
        return dao.getByNameContaining(subName);
    }

    @Override
    public void add(Product product) {
        dao.save(product);
        productStockInfoService.add(product.getId());
    }
}
