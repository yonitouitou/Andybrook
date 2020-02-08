package com.andybrook.service.product;

import com.andybrook.dao.stock.barcode.IBarCodeDao;
import com.andybrook.model.BarCode;

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
    public void newBarCode(BarCode barCode) {
        dao.save(barCode);
    }

    @Override
    public boolean isBarCodeExist(String barCodeId) {
        return dao.get(barCodeId).isPresent();
    }
}
