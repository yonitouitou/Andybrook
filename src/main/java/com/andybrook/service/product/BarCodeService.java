package com.andybrook.service.product;

import com.andybrook.dao.stock.IBarCodeDao;
import com.andybrook.exception.BarCodeNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class BarCodeService implements IBarCodeService {

    @Autowired
    private IBarCodeDao dao;

    @Override
    public BarCode get(String id) {
        Optional<BarCode> barCodeOpt = dao.get(id);
        return barCodeOpt.isPresent() ? barCodeOpt.get() : null;
    }

    @Override
    public Product getProduct(String barCodeId) {
        Product product;
        Optional<Product> productOpt = dao.getProduct(barCodeId);
        if (productOpt.isPresent()) {
            product = productOpt.get();
        } else {
            throw new BarCodeNotFound(barCodeId);
        }
        return product;
    }

    @Override
    public void newBarCode(Product product, BarCode barCode) {
        dao.save(product, barCode);
    }

    @Override
    public boolean isBarCodeExist(String barCodeId) {
        return dao.get(barCodeId).isPresent();
    }
}
