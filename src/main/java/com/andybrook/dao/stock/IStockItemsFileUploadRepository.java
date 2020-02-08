package com.andybrook.dao.stock;

import com.andybrook.model.api.StockItemsFileUpload;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IStockItemsFileUploadRepository extends ElasticsearchRepository<StockItemsFileUpload, String> {
}
