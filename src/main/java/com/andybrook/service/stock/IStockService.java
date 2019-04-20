package com.andybrook.service.stock;

import com.andybrook.model.BarCode;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.model.stock.ProductItem;

public interface IStockService {

    ProductItem getProductItem(long id);

    ProductItem getProductItemByBarCode(BarCode barCode);

    void addProductItem(ProductItemInfo productItemInfo);

    int getFreeQuantity(long productId);
}
