package com.andybrook.service.stock;

import com.andybrook.dao.stock.productitem.IProductItemDao;
import com.andybrook.exception.BarCodeNotFound;
import com.andybrook.exception.BarCodeNotLinked;
import com.andybrook.exception.ProductItemNotFound;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.product.IBarCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class ProductItemService implements IProductItemService {

    @Autowired
    private IProductItemDao dao;
    @Autowired
    private IBarCodeService barCodeService;

    @Override
    public void add(ProductItem productItem) {
        updateProductItem(productItem);
    }

    @Override
    public ProductItem get(long productItemId) {
        Optional<ProductItem> productItemOpt = dao.get(productItemId);
        return productItemOpt.orElseThrow(() -> new ProductItemNotFound(productItemId));
    }

    @Override
    public ProductItem getByBarCodeId(String barCodeId) {
        ProductItem productItem;
        boolean isExist = barCodeService.isBarCodeExist(barCodeId);
        if (isExist) {
            Optional<ProductItem> productItemOpt = dao.findByBarCodeId(barCodeId);
            productItem = productItemOpt.orElseThrow(() -> new BarCodeNotLinked(barCodeId));
        } else {
            throw new BarCodeNotFound(barCodeId);
        }
        return productItem;
    }

    @Override
    public int getProductItemSize(ProductId productId) {
        return dao.getProductItemSize(productId);
    }

    @Override
    public void update(ProductItem productItem) {
        updateProductItem(productItem);
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(ProductId productId) {
        return dao.findFreeProductItemOf(productId);
    }

    private void updateProductItem(ProductItem productItem) {
        dao.save(productItem);
    }
}
