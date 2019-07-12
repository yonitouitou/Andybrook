package com.andybrook.dao.stock;

import com.andybrook.dao.jpa.entity.stock.StockItemFileUploadEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IProductFileUploadRepository extends ElasticsearchRepository<StockItemFileUploadEntity, String> {


}
