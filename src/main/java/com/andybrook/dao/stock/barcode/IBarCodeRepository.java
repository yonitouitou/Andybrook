package com.andybrook.dao.stock.barcode;

import com.andybrook.model.BarCode;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IBarCodeRepository extends ElasticsearchRepository<BarCode, String> {
}
