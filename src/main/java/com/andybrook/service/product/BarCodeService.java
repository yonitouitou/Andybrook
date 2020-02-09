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
    public BarCode get(BarCode barCode) {
        Optional<BarCode> barCodeOpt = dao.get(barCode);
        return barCodeOpt.isPresent() ? barCodeOpt.get() : null;
    }

    @Override
    public void newBarCode(BarCode barCode) {
        dao.save(barCode);
    }

    @Override
    public boolean isBarCodeExist(BarCode barCode) {
        return dao.get(barCode).isPresent();
    }
}
