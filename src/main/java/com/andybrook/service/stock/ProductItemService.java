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
    public ProductItem add(ProductItem productItem) {
        return updateProductItem(productItem);
    }

    @Override
    public ProductItem get(long productItemId) {
        Optional<ProductItem> productItemOpt = dao.find(productItemId);
        return productItemOpt.orElseThrow(() -> new ProductItemNotFound(productItemId));
    }

    @Override
    public ProductItem update(ProductItem productItem) {
        return updateProductItem(productItem);
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(long productId) {
        return dao.findFreeProductItemOf(productId);
    }

    private ProductItem updateProductItem(ProductItem productItem) {
        return dao.update(productItem);
    }
}
