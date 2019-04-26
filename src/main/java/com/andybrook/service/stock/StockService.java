package com.andybrook.service.stock;

import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService implements IStockService {

    @Autowired
    private IProductStockInfoService productStockInfoService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductItemService productItemService;

    @Override
    public ProductItem addProductItem(ProductItem productItem) {
        Product product = productService.get(productItem.getProduct().getId());
        productItem = productItemService.add(productItem);
        productStockInfoService.incrementQuantityCreated(product.getId());
        return productItem;
    }

    @Override
    public ProductItem getProductItem(long productItemId) {
        return productItemService.get(productItemId);
    }

    @Override
    public ProductItem updateProductItem(ProductItem productItem) {
        return productItemService.update(productItem);
    }

    @Override
    public Optional<ProductItem> findFreeProductItemOf(long productId) {
        return productItemService.findFreeProductItemOf(productId);
    }

    @Override
    public List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity) {
        return productStockInfoService.getAllProductNamesWithQuantityMoreThan(quantity);
    }



}
