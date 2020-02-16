package com.andybrook.service.stock;

import com.andybrook.dao.stock.productitem.IProductItemDao;
import com.andybrook.exception.BarCodeNotFound;
import com.andybrook.exception.ProductItemNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.product.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class ProductItemService implements IProductItemService {

    @Autowired
    private IProductItemDao dao;
    @Autowired
    private IProductService productService;

    @Override
    public void add(ProductItem productItem) {
        dao.save(productItem);
    }

    @Override
    public ProductItem get(long productItemId) {
        Optional<ProductItem> productItemOpt = dao.get(productItemId);
        return productItemOpt.orElseThrow(() -> new ProductItemNotFound(productItemId));
    }

    @Override
    public ProductItem getByBarCode(BarCode barCode) {
        Optional<ProductItem> productItemOpt = dao.findByBarCode(barCode);
        return productItemOpt.orElseThrow(() -> new BarCodeNotFound(barCode));
    }

    @Override
    public int getProductItemSize(ProductId productId) {
        return dao.getProductItemSize(productId);
    }

    @Override
    public void update(ProductItem productItem) {
        if (dao.exist(productItem.getId())) {
            dao.save(productItem);
        } else {
            throw new ProductItemNotFound(productItem.getId());
        }
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(ProductId productId) {
        return dao.findFreeProductItemOf(productId);
    }

    @Override
    public double getPrice(ProductItem productItem) {
        Product product = productService.get(productItem.getProductId());
        return product.getPrice();
    }
}
