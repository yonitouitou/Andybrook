package com.andybrook.dao.product;

import com.andybrook.model.stock.ProductStockInfo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IProductStockInfoRepository extends ElasticsearchRepository<ProductStockInfo, Long> {
}
