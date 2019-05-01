package com.andybrook.service.stock;

import com.andybrook.dao.stock.IProductItemDao;
import com.andybrook.exception.ProductItemNotFound;
import com.andybrook.model.stock.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class ProductItemService implements IProductItemService {

    @Autowired
    private IProductItemDao dao;

    @Override
    public void add(ProductItem productItem) {
        updateProductItem(productItem);
    }

    @Override
    public ProductItem get(long productItemId) {
        Optional<ProductItem> productItemOpt = dao.find(productItemId);
        return productItemOpt.orElseThrow(() -> new ProductItemNotFound(productItemId));
    }

    @Override
    public int getProductItemSize(long productId) {
        return dao.getProductItemSize(productId);
    }

    @Override
    public void update(ProductItem productItem) {
        updateProductItem(productItem);
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(long productId) {
        return dao.findFreeProductItemOf(productId);
    }

    private void updateProductItem(ProductItem productItem) {
        dao.update(productItem);
    }
}
