package com.andybrook.service.product;

import com.andybrook.dao.product.IProductDao;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.product.Product;
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
    private IBarCodeService barCodeService;
    @Autowired
    private IProductStockInfoService productStockInfoService;

    @Override
    public Product get(long id) throws ProductNotFound {
        Product product;
        Optional<Product> productOpt = dao.get(id);
        if (productOpt.isPresent()) {
            product = productOpt.get();
        } else {
            throw new ProductNotFound(id);
        }
        return product;
    }

    @Override
    public Optional<Product> getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public boolean isExist(long id) {
        return dao.isExist(id);
    }

    @Override
    public Product getByBarCode(String barCodeId) {
        return barCodeService.getProduct(barCodeId);
    }

    @Override
    public Product update(Product product) {
        return dao.save(product);
    }

    @Override
    public List<? extends Product> getByNameContaining(String subName) {
        return dao.getByNameContaining(subName);
    }

    @Override
    public Product addProduct(Product product) {
        Product productAdded = dao.update(product);
        productStockInfoService.add(productAdded.getId());
        return productAdded;
    }
}
