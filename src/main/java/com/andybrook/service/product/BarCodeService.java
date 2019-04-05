package com.andybrook.service.product;

import com.andybrook.dao.stock.IBarCodeDao;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public void newBarCode(Product product, BarCode barCode) {
        dao.save(product, barCode);
    }

    @Override
    public long getOrderItemIdByBarCodeId(String id) {
        return dao.getStockItemIdByBarCodeId(id);
    }

    @Override
    public boolean isBarCodeExist(BarCode barCode) {
        return dao.get(barCode.getId()).isPresent();
    }
}
