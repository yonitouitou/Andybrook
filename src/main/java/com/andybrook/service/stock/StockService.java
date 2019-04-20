package com.andybrook.service.stock;

import com.andybrook.model.BarCode;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.model.stock.ProductItem;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService {

    @Override
    public ProductItem getProductItem(long id) {
        return null;
    }

    @Override
    public ProductItem getProductItemByBarCode(BarCode barCode) {
        return null;
    }

    @Override
    public void addProductItem(ProductItemInfo productItemInfo) {

    }

    @Override
    public int getFreeQuantity(long productId) {
        return 0;
    }
}
