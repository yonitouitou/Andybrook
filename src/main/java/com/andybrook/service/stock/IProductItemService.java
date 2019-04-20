package com.andybrook.service.stock;

import com.andybrook.model.stock.ProductItem;

interface IProductItemService {

    ProductItem add(ProductItem productItem);

    ProductItem get(long productItemId);
}
