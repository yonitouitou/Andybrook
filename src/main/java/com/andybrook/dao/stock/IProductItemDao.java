package com.andybrook.dao.stock;

import com.andybrook.model.stock.ProductItem;

public interface IProductItemDao {

    ProductItem update(ProductItem productItem);

    ProductItem delete(long id);

    ProductItem get(long id);
}
