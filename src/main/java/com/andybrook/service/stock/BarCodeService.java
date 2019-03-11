package com.andybrook.service.stock;

import com.andybrook.dao.stock.IBarCodeDao;
import com.andybrook.model.BarCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarCodeService implements IBarCodeService {

    @Autowired
    private IBarCodeDao dao;

    @Override
    public long getStockItemIdByBarCodeId(String id) {
        return dao.getStockItemIdByBarCodeId(id);
    }

    @Override
    public boolean isBarCodeExist(BarCode barCode) {
        return dao.get(barCode.getId()).isPresent();
    }
}
