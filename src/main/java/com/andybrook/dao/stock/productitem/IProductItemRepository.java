package com.andybrook.dao.stock.productitem;

import com.andybrook.model.stock.ProductItem;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

interface IProductItemRepository extends ElasticsearchRepository<ProductItem, Long> {

}
