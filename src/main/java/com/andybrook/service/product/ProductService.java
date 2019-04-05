package com.andybrook.service.product;

import com.andybrook.dao.product.glasses.IProductDao;
import com.andybrook.exception.BarCodeAlreadyExist;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDao dao;
    @Autowired
    private IBarCodeService barCodeService;

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
    public List<? extends Product> getByNameContaining(String subName) {
        return dao.getByNameContaining(subName);
    }

    @Override
    public Product addProduct(Product product) {
        return dao.update(product);
    }

    @Override
    public void addBarCode(long productId, BarCode barCode) throws BarCodeAlreadyExist, ProductNotFound {
        if (! barCodeService.isBarCodeExist(barCode)) {
            Optional<Product> productOpt = dao.get(productId);
            if (productOpt.isPresent()) {
                Product product = productOpt.get();
                product.addBarCode(barCode);
                dao.update(product);
            } else {
                throw new ProductNotFound(productId);
            }
        } else {
            throw new BarCodeAlreadyExist(barCode.getId());
        }
    }

    @Override
    public List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return dao.getAllProductNamesWithQuantityMoreThan(quantity);
    }
}
