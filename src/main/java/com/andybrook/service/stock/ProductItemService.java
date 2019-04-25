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
        return dao.update(productItem);
    }

    @Override
    public ProductItem get(long productItemId) {
        ProductItem productItem;
        Optional<ProductItem> productItemOpt = dao.find(productItemId);
        if (productItemOpt.isPresent()) {
            productItem = productItemOpt.get();
        } else {
            throw new ProductItemNotFound(productItemId);
        }
        return productItem;
    }
}
