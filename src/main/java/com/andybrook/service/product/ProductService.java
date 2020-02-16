package com.andybrook.service.product;

import com.andybrook.dao.product.IProductDao;
import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;
import com.andybrook.service.product.glasses.GlassesService;
import com.andybrook.service.stock.IProductStockInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class ProductService implements IProductService {

    private EnumMap<ProductType, Class<? extends IProductTypeService>> productServicesMapByType = new EnumMap<>(ProductType.class);

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private IProductDao dao;
    @Autowired
    private IProductStockInfoService productStockInfoService;

    @PostConstruct
    private void init() {
        productServicesMapByType.put(ProductType.GLASSES, GlassesService.class);
    }

    @Override
    public Product get(ProductId id) {
        IProductTypeService service = getProductTypeService(id.getProductType());
        return service.get(id);
    }

    @Override
    public Product getByName(ProductType productType, String name) {
        IProductTypeService service = getProductTypeService(productType);
        return service.getByName(name);
    }

    @Override
    public boolean isExist(ProductId id) {
        IProductTypeService service = getProductTypeService(id.getProductType());
        return service.isExist(id);
    }

    @Override
    public List<? extends Product> getByNameContaining(ProductType type, String subName) {
        IProductTypeService service = getProductTypeService(type);
        return service.getByNameContaining(subName);
    }

    @Override
    public void add(Product product) {
        dao.save(product);
        productStockInfoService.add(product.getId());
    }

    private IProductTypeService getProductTypeService(ProductType productType) {
        Class<? extends IProductTypeService> theClass = productServicesMapByType.get(productType);
        if (theClass == null) {
            throw new UnsupportedOperationException("ProductTypeService not found for : " + productType);
        }
        return applicationContext.getBean(theClass);
    }
}
