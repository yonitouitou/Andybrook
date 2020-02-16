package com.andybrook.dao.product.glasses;

import com.andybrook.model.product.Glasses;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IGlassesRepository extends ElasticsearchRepository<Glasses, String> {
}
