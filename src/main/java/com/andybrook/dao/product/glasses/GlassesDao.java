package com.andybrook.dao.product.glasses;

import com.andybrook.dao.product.IGlassesDao;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.ProductId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GlassesDao implements IGlassesDao {

    @Autowired
    private ElasticsearchOperations template;
    @Autowired
    private IGlassesRepository repository;

    @Override
    public void save(Glasses glasses) {
        repository.save(glasses);
    }

    @Override
    public Optional<Glasses> get(ProductId id) {
        return repository.findById(id.get());
    }

    @Override
    public boolean isExist(ProductId id) {
        return repository.existsById(id.get());
    }

    @Override
    public Optional<Glasses> getByName(String name) {
        Glasses glasses = template.queryForObject(new CriteriaQuery(
                Criteria.where("name").is(name)
        ), Glasses.class);
        return Optional.ofNullable(glasses);
    }

    @Override
    public List<Glasses> getByNameContaining(String subName) {
        return template.queryForList(new CriteriaQuery(
                Criteria.where("name").contains(subName)
        ), Glasses.class);
    }
}
